package com.geinzz.geinzwork.fragmentos


import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Typeface
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.geinzwork.constantesGeneral.Variables
import com.example.geinzwork.constantesGeneral.constantes_trabajadores_info
import com.example.geinzwork.constantesGeneral.constatnes_carga_imagenes_general
import com.geinzz.geinzwork.GenerarQR_trabajador
import com.geinzz.geinzwork.R
import com.geinzz.geinzwork.adapterViewholder.adapterTrabajo_realizados
import com.geinzz.geinzwork.constantesGeneral.constantes
import com.geinzz.geinzwork.constantesGeneral.constantesPublicidad
import com.geinzz.geinzwork.constantesGeneral.constantes_publicaciones_general_user_tiendas
import com.geinzz.geinzwork.constantesGeneral.constantes_redes
import com.geinzz.geinzwork.constantesGeneral.constantestextos_general
import com.geinzz.geinzwork.databinding.BottomSheetContactaTrabajadorBinding
import com.geinzz.geinzwork.databinding.FragmentInfoBinding
import com.geinzz.geinzwork.databinding.ItemCustomFixedSizeLayout2Binding
import com.geinzz.geinzwork.dataclass.dataClassTrabajosd
import com.geinzz.geinzwork.dataclass.dataclas_trabajos_ralizados
import com.geinzz.geinzwork.problemas_soporte_politicas.probleas_usuarios_formulario
import com.geinzz.geinzwork.vistaTrabajador.vista_CategoriasT
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.imageview.ShapeableImageView
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.dynamiclinks.androidParameters
import com.google.firebase.dynamiclinks.dynamicLinks
import com.google.firebase.dynamiclinks.googleAnalyticsParameters
import com.google.firebase.dynamiclinks.iosParameters
import com.google.firebase.dynamiclinks.itunesConnectAnalyticsParameters
import com.google.firebase.dynamiclinks.shortLinkAsync
import com.google.firebase.dynamiclinks.socialMetaTagParameters
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import org.imaginativeworld.whynotimagecarousel.utils.setImage
import java.net.URLEncoder

class info : Fragment() {
    private lateinit var binding: FragmentInfoBinding
    private lateinit var mContex: Context
    private var listAdapter = mutableListOf<dataclas_trabajos_ralizados>()
    private var listaTrabajo = mutableListOf<dataClassTrabajosd>()
    private lateinit var dialog: BottomSheetDialog
    private lateinit var firebaseAuth: FirebaseAuth
    private var phoneNumberToCall: String? = null

    companion object {
        private const val ARG_ID_TRABAJADOR = "id_trabajador"
        private const val IMAGEN_PERFIL = Variables.imagenPerfil

        private const val NOMBRE = Variables.nombre
        private const val NACIONALIDAD = "nacionalidad"
        private const val CATEGORIA = "categoria"


        fun newInstance(
            idTrabajador: String,
            imgPerfil: String,
            nombreUSer: String,
            nacionalidad: String,
            categoria: String,
        ): info {
            val fragment = info()
            val args = Bundle()
            args.putString(ARG_ID_TRABAJADOR, idTrabajador)
            args.putString(IMAGEN_PERFIL, imgPerfil)
            args.putString(NOMBRE, nombreUSer)
            args.putString(NACIONALIDAD, nacionalidad)
            args.putString(CATEGORIA, categoria)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        mContex = context
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentInfoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()
        val idTrabajador = arguments?.getString(ARG_ID_TRABAJADOR).toString()
        val img = arguments?.getString(IMAGEN_PERFIL).toString()
        val nombre = arguments?.getString(NOMBRE).toString()
        val nacionalidad = arguments?.getString(NACIONALIDAD).toString()
        val categoria = arguments?.getString(CATEGORIA).toString()
        obtenerImagenesFirestorage(idTrabajador)
        constantes.carga(3000, { mostrarDatos() })

        binding.qrTrabajador.setOnClickListener {
            var vista = Intent(mContex, GenerarQR_trabajador::class.java).apply {
                putExtra(Variables.info, Variables.info)
                putExtra(Variables.idTrabajdor, idTrabajador)
            }
            startActivity(vista)
        }
        binding.popup.setOnClickListener { popup(idTrabajador, nombre, nacionalidad, categoria) }
        obtenerDatosTrabajador(idTrabajador) { categoria ->
            constantes_trabajadores_info.obtenerMejoresTrabajadores(
                categoria,
                listaTrabajo,
                binding.trabajadoresSimilares,
                mContex, true
            )
            binding.verMasTrabajadores.setOnClickListener {
                var intent = Intent(mContex, vista_CategoriasT::class.java)
                intent.putExtra(Variables.valor, categoria)
                startActivity(intent)
                (mContex as? Activity)?.finish()
            }
        }



        binding.ig.setOnClickListener {
            obtenerRedes(mContex, Variables.ig, idTrabajador)
        }
        binding.fb.setOnClickListener {
            obtenerRedes(mContex, Variables.fb, idTrabajador)
        }
        binding.tk.setOnClickListener {
            obtenerRedes(mContex, Variables.tk, idTrabajador)
        }
        obtenerPerfil(idTrabajador, img)


    }

    private fun mostrarDatos() {
        binding.loading.isVisible = false
        binding.linealappLayout.isVisible = true

    }

    @SuppressLint("MissingInflatedId")
    private fun bottomShetContacto(numero: String) {
        val idTrabajador = arguments?.getString(ARG_ID_TRABAJADOR).toString()
        val bindings = BottomSheetContactaTrabajadorBinding.inflate(LayoutInflater.from(context))
        dialog.setContentView(bindings.root)
        bindings.whatsapp.setOnClickListener {
            val db = FirebaseFirestore.getInstance().collection(Variables.solicitud_servicios)
                .document(Variables.verificacionesDB).collection(Variables.activos)
                .document(idTrabajador)
            constantesPublicidad.agregarCantidadClickAnuncios(db, "", Variables.contactadoWhatsapp)
            val mensaje =
                "Hola, estoy interesado en obtener más información sobre el trabajo que vi en Geinz. Gracias."

            val uri = Uri.parse(
                "https://api.whatsapp.com/send?phone=$numero&text=${
                    URLEncoder.encode(
                        mensaje,
                        "UTF-8"
                    )
                }"
            )
            val intent = Intent(Intent.ACTION_VIEW, uri)

            try {
                startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(mContex, "No se pudo abrir WhatsApp", Toast.LENGTH_SHORT).show()
            }
            dialog.dismiss()
        }

        bindings.llamado.setOnClickListener {
            val db = FirebaseFirestore.getInstance().collection(Variables.solicitud_servicios)
                .document(Variables.verificacionesDB).collection(Variables.activos)
                .document(idTrabajador)
            constantesPublicidad.agregarCantidadClickAnuncios(db, "", Variables.llamadas)
            showPermissionDialog(mContex, numero)
            dialog.dismiss()
        }

        dialog.show() // Asegúrate de mostrar el diálogo aquí
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SuspiciousIndentation")
    private fun obtenerPerfil(id: String, img: String) {
        val placeholderPortada =
            ContextCompat.getDrawable(mContex, R.drawable.sin_foto_portada_con_marca)
        val placeholder = ContextCompat.getDrawable(mContex, R.drawable.img_perfil)

        val refStorage =
            FirebaseStorage.getInstance().getReference(Variables.usuarios_db)
                .child(id).child(Variables.foto_portada)
        refStorage.downloadUrl.addOnSuccessListener { uri ->

            val imgUrl = uri.toString()
            constatnes_carga_imagenes_general.changer_img(
                binding.progressCargaImagenFondo,
                mContex,
                imgUrl,
                null,
                binding.imgPortada,
                "portada", placeholderPortada
            )
        }

        constantes.obtenerEstado(binding.estado, id)

        constatnes_carga_imagenes_general.changer_img(
            binding.progressCargaImagen,
            mContex,
            img,
            binding.imgPerfilUser,
            null,
            "perfil", placeholder
        )


    }

    private fun obtenerImagenesFirestorage(idT: String) {
        val id = idT
        val referenciaStorage =
            FirebaseStorage.getInstance().getReference(Variables.usuarios_db).child(id)

        val lista = mutableListOf<CarouselItem>()

        if (referenciaStorage != null) {
            val nombreImagen1 = Variables.imgane1
            val nombreImagen2 = Variables.imagen2
            val nombreImagen3 = Variables.imagen3
            val referenciaImagen1 = referenciaStorage.child(nombreImagen1)
            val referenciaImagen2 = referenciaStorage.child(nombreImagen2)
            val referenciaImagen3 = referenciaStorage.child(nombreImagen3)

            referenciaImagen1.downloadUrl.addOnSuccessListener { url1 ->
                val urlImagen1 = url1.toString()
                val carouselItem1 = CarouselItem(urlImagen1)
                println("obtenemos url 1 ${urlImagen1}")
                lista.add(carouselItem1)

                referenciaImagen2.downloadUrl.addOnSuccessListener { url2 ->
                    val urlImagen2 = url2.toString()
                    val carouselItem2 = CarouselItem(urlImagen2)
                    println("obtenemos url 2 ${urlImagen2}")
                    lista.add(carouselItem2)

                    referenciaImagen3.downloadUrl.addOnSuccessListener { url3 ->
                        val urlImagen3 = url3.toString()
                        val carouselItem3 = CarouselItem(urlImagen3)
                        println("obtenemos url 3 ${urlImagen3}")
                        lista.add(carouselItem3)

                        binding.carrusel.registerLifecycle(lifecycle)
                        binding.carrusel.carouselListener = object : CarouselListener {
                            override fun onCreateViewHolder(
                                layoutInflater: LayoutInflater,
                                parent: ViewGroup,
                            ): ViewBinding? {
                                return ItemCustomFixedSizeLayout2Binding.inflate(
                                    layoutInflater,
                                    parent,
                                    false
                                )
                            }

                            override fun onBindViewHolder(
                                binding: ViewBinding,
                                item: CarouselItem,
                                position: Int,
                            ) {
                                val currentBinding = binding as ItemCustomFixedSizeLayout2Binding
                                currentBinding.imageView.apply {
                                    scaleType = ImageView.ScaleType.CENTER_CROP
                                    setImage(item, R.drawable.ic_wb_cloudy_with_padding)
                                    minimumScale = 1f
                                    maximumScale = 10f
                                    mediumScale = 5f
                                }
                            }
                        }
                        binding.carrusel.setData(lista)
                    }.addOnFailureListener { e3 ->
                        println("Error al obtener la URL de la imagen 3: $e3")
                    }
                }.addOnFailureListener { e2 ->
                    println("Error al obtener la URL de la imagen 2: $e2")
                }
            }.addOnFailureListener { e1 ->
                println("Error al obtener la URL de la imagen 1: $e1")
                val drawableId = R.drawable.no_cuenta_img
                val carouselItem1 = CarouselItem(drawableId)
                val carouselItem2 = CarouselItem(drawableId)
                val carouselItem3 = CarouselItem(drawableId)
                lista.add(carouselItem1)
                lista.add(carouselItem2)
                lista.add(carouselItem3)
                binding.carrusel.setData(lista)

            }
        }
    }

    private fun popup(
        idTrabajador: String,
        nombre: String,
        nacionalidad: String,
        categoria: String,
    ) {

        val popup = PopupMenu(mContex, binding.popup)
        popup.menu.add(Menu.NONE, 1, 1, "Contactar")
        popup.menu.add(Menu.NONE, 2, 2, "Compartir perfil")
        popup.menu.add(Menu.NONE, 3, 3, "Reportar Trabajador")
        popup.show()
        popup.setOnMenuItemClickListener { item ->
            val itemID = item.itemId
            if (itemID == 1) {
                if (firebaseAuth.currentUser == null) {
                    dialog = BottomSheetDialog(mContex)
                    constantesPublicidad.CreacionCuentaBottom_shett(
                        mContex,
                        dialog
                    )
                    dialog.show()

                } else {
                    dialog = BottomSheetDialog(mContex)
                    bottomShetContacto(binding.telefono.text.toString())
                    dialog.show()
                }
            } else if (itemID == 2) {
                val db = FirebaseFirestore.getInstance().collection(Variables.solicitud_servicios)
                    .document(Variables.verificacionesDB).collection(Variables.activos)
                    .document(idTrabajador)
                constantesPublicidad.agregarCantidadClickAnuncios(db, "", Variables.compartidas)
                createAndShareDynamicLink(idTrabajador)
            } else if (itemID == 3) {
                if (firebaseAuth.uid.toString() == idTrabajador) {
                    Toast.makeText(mContex, "No puedes reportarte a ti mismo", Toast.LENGTH_SHORT)
                        .show()
                } else if (firebaseAuth.currentUser == null) {
                    dialog = BottomSheetDialog(mContex)
                    constantesPublicidad.CreacionCuentaBottom_shett(
                        mContex,
                        dialog
                    )
                    dialog.show()

                } else {
                    val vista = Intent(mContex, probleas_usuarios_formulario::class.java).apply {
                        putExtra(Variables.idTrabajador, idTrabajador)
                        putExtra(Variables.nombreUSer, nombre)
                        putExtra(Variables.categoria, categoria)
                        putExtra(Variables.nacionalidad, nacionalidad)
                    }
                    startActivity(vista)
                }
            }
            return@setOnMenuItemClickListener true
        }
    }


    private fun obtenerRedes(context: Context, red: String, idTrabajador: String) {
        val userCollections =
            FirebaseFirestore.getInstance().collection(Variables.trabajadores_usuariosDB)
                .document(Variables.trabajadoresDB).collection(Variables.trabajadoresDB)
                .document(idTrabajador)
        userCollections.get().addOnSuccessListener { res ->
            if (res.exists()) {
                val data = res.data
                val ig = data?.get(Variables.IG) as? String ?: ""
                val fb = data?.get(Variables.FB) as? String ?: ""
                val tk = data?.get(Variables.TK) as? String ?: ""

                when (red) {
                    Variables.ig -> {
                        constantes_redes.openApps(context, ig, "com.instagram.android")
                    }

                    Variables.fb -> {
                        constantes_redes.openApps(context, fb, "com.facebook.katana")
                    }

                    Variables.tk -> {
                        constantes_redes.openApps(context, tk, "com.zhiliaoapp.musically")
                    }
                }
            }
        }

    }

    @SuppressLint("SetTextI18n")
    private fun obtenerDatosTrabajador(
        idUSer: String,
        categoria_trabajadorReturn: (String) -> Unit,
    ) {
        val userCollections =
            FirebaseFirestore.getInstance().collection(Variables.trabajadores_usuariosDB)
                .document(Variables.trabajadoresDB).collection(Variables.trabajadoresDB)
                .document(idUSer)
        userCollections.get().addOnSuccessListener { res ->
            if (res.exists()) {
                val data = res.data
                val nombre = data?.get(Variables.nombre) as? String ?: ""
                val descripcion = data?.get(Variables.descripcion) as? String ?: ""
                val categoriaTrabajo = data?.get(Variables.categoriaTrabajo) as? String ?: ""
                val genero = data?.get(Variables.genero) as? String ?: ""
                val horario1 = data?.get(Variables.horario1) as? String ?: ""
                val horario2 = data?.get(Variables.horario2) as? String ?: ""
                val nacionalidad = data?.get(Variables.nacionalidad) as? String ?: ""
                val localidad = data?.get(Variables.localidad) as? String ?: ""
                val codigo_pais = data?.get(Variables.codigo_pais) as? String ?: ""
                val numero = data?.get(Variables.numero) as? String ?: ""
                val tipoTrabajo = data?.get(Variables.tipoTrabajo) as? String ?: ""
                val EdadActual = data?.get(Variables.EdadActual) as? String ?: ""
                val ig = data?.get(Variables.IG) as? String ?: ""
                val fb = data?.get(Variables.FB) as? String ?: ""
                val tk = data?.get(Variables.TK) as? String ?: ""

                verificarEstado_verificacion(fb, ig, tk, idUSer)
                binding.nombre.text = nombre.toUpperCase()
                binding.categoriaTipoTrabajo.text = "$tipoTrabajo | $categoriaTrabajo"
                categoria_trabajadorReturn("$categoriaTrabajo")

                constantestextos_general.extender_acortar_texto(
                    binding.caracteristica1,
                    binding.tvReadMore
                )

                val spannableString =
                    SpannableString("${"Descripcion : "} ${descripcion}")

                val boldSpan = StyleSpan(Typeface.BOLD)
                val startIndex = 0
                val endIndex = "Descripcion : ".length
                spannableString.setSpan(
                    boldSpan,
                    startIndex,
                    endIndex,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )

                binding.caracteristica1.text = spannableString

                binding.genero.text = genero
                binding.nacionalida.text = nacionalidad
                binding.localidad.text = localidad
                binding.horario.text = "${horario1} am : ${horario2} pm"
                binding.telefono.text = "+${codigo_pais} ${numero}"
                binding.edadUser.text = "${EdadActual} años"
            }
        }
            .addOnFailureListener { e ->
                println("error al obtner los datos $e")
            }
    }


    private val REQUEST_CALL_PHONE = 1

    private fun showPermissionDialog(context: Context, phoneNumber: String) {
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            AlertDialog.Builder(context)
                .setTitle("Permiso necesario")
                .setMessage("Esta aplicación necesita permiso para realizar llamadas. Por favor, activa el permiso.")
                .setPositiveButton("Aceptar") { dialog, which ->
                    requestCallPermission(context, phoneNumber)
                }
                .setNegativeButton("Cancelar") { dialog, which ->
                    Toast.makeText(context, "Permiso de llamada denegado", Toast.LENGTH_SHORT)
                        .show()
                }
                .show()
        } else {

            makePhoneCall(context, phoneNumber)
        }
    }

    private fun requestCallPermission(context: Context, phoneNumber: String) {
        phoneNumberToCall = phoneNumber
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                mContex as Activity,
                arrayOf(Manifest.permission.CALL_PHONE),
                REQUEST_CALL_PHONE
            )
        } else {
            makePhoneCall(context, phoneNumber)
        }
    }

    private fun makePhoneCall(context: Context, phoneNumber: String) {
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:$phoneNumber")
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.CALL_PHONE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            context.startActivity(callIntent)
        } else {
            requestCallPermission(context, phoneNumber)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CALL_PHONE) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                // Permiso concedido, realiza la llamada
                phoneNumberToCall?.let { makePhoneCall(mContex, it) }
            } else {
                Toast.makeText(mContex, "Permiso de llamada denegado", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun verificarEstado_verificacion(fb: String, ig: String, tk: String, id: String) {
        val verificado = binding.verificado
        val banerPublicacionesRecientes = binding.banerPublicacionesRecientes
        val trabajosRealizados = binding.TrabajosRealizados
        val linealRedes = binding.linealRedes
        val igView = binding.ig
        val fbView = binding.fb
        val tkView = binding.tk
        val linealappLayout = binding.linealappLayout
        val linealNoCuenta = binding.linealNoCuenta
        val linealTrabajosRealizados = binding.linealTrabajosRealziados

        val db = FirebaseFirestore.getInstance().collection(Variables.solicitud_servicios)
            .document(Variables.verificacionesDB).collection(Variables.activos).document(id)

        db.get().addOnSuccessListener { res ->
            if (res.exists()) {
                val data = res.data
                val estado = data?.get(Variables.estado) as? Boolean ?: false
                val plan = data?.get(Variables.plan) as? String? ?: ""
                if (estado) {
                    verificado.isVisible = true
                    banerPublicacionesRecientes.isVisible = true
                    val adapter = adapterTrabajo_realizados(listAdapter)
                    constantes_publicaciones_general_user_tiendas.obtenerPublicaciones(
                        plan,
                        id,
                        listAdapter,
                        trabajosRealizados,
                        mContex,
                        adapter,
                        linealappLayout,
                        linealNoCuenta,
                        linealTrabajosRealizados
                    )


                    linealRedes.isVisible = ig.isNotEmpty() || fb.isNotEmpty() || tk.isNotEmpty()
                    igView.isVisible = ig.isNotEmpty()
                    fbView.isVisible = fb.isNotEmpty()
                    tkView.isVisible = tk.isNotEmpty()

                } else {
                    verificado.isVisible = false
                    banerPublicacionesRecientes.isVisible = false
                    trabajosRealizados.isVisible = false
                }
            } else {
                verificado.isVisible = false
                banerPublicacionesRecientes.isVisible = false
                trabajosRealizados.isVisible = false
            }
        }.addOnFailureListener {
            println("No se encontró la verificación del usuario")
        }
    }

    @SuppressLint("StringFormatInvalid")
    private fun createAndShareDynamicLink(
        idTrabajador: String,
    ) {
        val userCollections =
            FirebaseFirestore.getInstance().collection(Variables.trabajadores_usuariosDB)
                .document(Variables.trabajadoresDB).collection(Variables.trabajadoresDB)
                .document(idTrabajador)

        userCollections.get().addOnSuccessListener { res ->
            if (res.exists()) {
                val data = res.data
                val imgAnuncio = data?.get(Variables.imagenPerfil) as? String ?: ""
                val nombre = data?.get(Variables.nombre) as? String ?: ""
                val categoria = data?.get(Variables.categoriaTrabajo) as? String ?: ""

                if (imgAnuncio.isNotEmpty()) {
                    Firebase.dynamicLinks.shortLinkAsync {
                        link =
                            Uri.parse("https://geinzapp.page.link/?idTrabajadorGeinz=${idTrabajador}")
                        domainUriPrefix = "https://geinzapp.page.link"
                        androidParameters("com.geinzz.geinzwork") {
                            minimumVersion = 125
                        }
                        iosParameters("com.geinzz.ios") {
                            appStoreId = "123456789"
                            minimumVersion = "1.0.1"
                        }
                        googleAnalyticsParameters {
                            source = "orkut"
                            medium = "social"
                            campaign = "geinzz-promo"
                        }
                        itunesConnectAnalyticsParameters {
                            providerToken = "123456"
                            campaignToken = "geinzz-promo"
                        }
                        socialMetaTagParameters {
                            title = "!Mira este trabajad@r de Geinz Work $nombre"
                            description = "Categoria del trabajad@r : $categoria"
                            imageUrl = Uri.parse(imgAnuncio)
                        }
                    }.addOnSuccessListener { shortDynamicLink ->
                        val shortLink = shortDynamicLink.shortLink
                        val invitationLink = shortLink.toString()

                        val sendIntent: Intent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, invitationLink)
                            type = "text/plain"
                        }
                        startActivity(Intent.createChooser(sendIntent, null))
                    }.addOnFailureListener {
                        println("Hubo un error con los links dinámicos: $it")
                    }
                } else {
                    println("La URL de la imagen está vacía.")
                }
            } else {
                println("El anuncio no existe.")
            }
        }.addOnFailureListener { exception ->
            println("Error al obtener el anuncio: ${exception.message}")
        }
    }

}