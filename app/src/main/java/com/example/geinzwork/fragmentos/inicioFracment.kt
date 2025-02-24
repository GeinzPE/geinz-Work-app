package com.geinzz.geinzwork.fragmentos

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.geinzwork.constantesGeneral.Variables
import com.example.geinzwork.oferta_principales_geinz
import com.example.geinzwork.vistaTrabajador.ver_promociones
import com.geinzz.geinzwork.adapterViewholder.adapterTrabajosMostrados
import com.geinzz.geinzwork.constantesGeneral.constantes
import com.geinzz.geinzwork.constantesGeneral.constantesPublicidad
import com.geinzz.geinzwork.constantesGeneral.constantesSubcategoriaszonasTiendas
import com.geinzz.geinzwork.constantesGeneral.constantesTrabajadoresTiendasInicioFragmet
import com.geinzz.geinzwork.constantesGeneral.conteoUser
import com.geinzz.geinzwork.constantesGeneral.filtradoLocalidadElementos
import com.geinzz.geinzwork.databinding.FragmentInicioFracmentBinding
import com.geinzz.geinzwork.databinding.ItemCustomPublicidadPrincipalBinding
import com.geinzz.geinzwork.dataclass.dataClassCategoriasInicio
import com.geinzz.geinzwork.dataclass.dataClassTrabajosd
import com.geinzz.geinzwork.vistaTiendas.TiendasGenerales
import com.geinzz.geinzwork.vistaTrabajador.vistaTrabajador
import com.geinzz.geinzwork.vistaTrabajador.vista_CategoriasT
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.zxing.integration.android.IntentIntegrator
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class inicioFracment : Fragment() {

    private lateinit var binding: FragmentInicioFracmentBinding
    private lateinit var mContex: Context
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var dialog: BottomSheetDialog

    private val listaTrabajo = mutableListOf<dataClassTrabajosd>().toMutableList()
    private val KEY = "MY_KEY"

    override fun onAttach(context: Context) {
        mContex = context
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        firebaseAuth = FirebaseAuth.getInstance()
        binding = FragmentInicioFracmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        obtenerImagenesFirestorage()
        SetAnuncios()
        obtenerTrabajosCat()
        val pref = PreferenceManager.getDefaultSharedPreferences(mContex)

        val storedValue = pref?.getString(KEY, "Default Value")

        conteoUser.obtenerConteoUSer { usuarios ->
            binding.includeCabezero.usuariosRegistrados.text = usuarios.toString()
        }
        constantes.SolicitarPermisoNotificacion(mContex, permisoNotificaion)
        binding.includeCabezero.relativenotifica.setOnClickListener {
            initScanner()
        }
        binding.Tiendas.setOnClickListener {
            mContex.startActivity(Intent(mContex, ver_promociones::class.java))
        }


        if (firebaseAuth.currentUser == null && storedValue.isNullOrEmpty() || storedValue.equals("Default Value")) {
            constantesTrabajadoresTiendasInicioFragmet.obtenerLocalida(Variables.General)
            binding.includeCabezero.filtradoUsuairo.text = Variables.General
        } else {
            binding.includeCabezero.filtradoUsuairo.text = storedValue
            constantesTrabajadoresTiendasInicioFragmet.obtenerLocalida(storedValue!!)
        }

        if ( binding.includeCabezero.filtradoUsuairo.text.toString() == Variables.General) {
            obtnerFiltrado(Variables.General)
        } else {
            constantes.carga(5000, { mostrarDatos(storedValue!!) })
        }
        binding.includeCabezero.imgPerfilUser.setOnClickListener {
            if (firebaseAuth.currentUser == null) {
                dialog = BottomSheetDialog(mContex)
                constantesPublicidad.CreacionCuentaBottom_shett(
                    mContex,
                    dialog
                )
                dialog.show()

            } else {
                dialog = BottomSheetDialog(mContex)
                filtradoLocalidadElementos.filtradoNacionalidades(
                    "Seleccione su filtrado de Trabajadores y Tiendas",
                    mContex,
                    dialog
                ) { seleccion ->
                    binding.includeCabezero.filtradoUsuairo.text = "$seleccion"
                }
                dialog.show()
            }
        }

        binding.includeCabezero.filtradoUsuairo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                when (s.toString()) {
                    Variables.Supe -> {
                        obtnerFiltrado(Variables.Supe)
                        guardarShaderPref(pref, Variables.Supe)
                        constantesTrabajadoresTiendasInicioFragmet.obtenerLocalida(Variables.Supe)
                    }

                    Variables.Barranca -> {
                        obtnerFiltrado(Variables.Barranca)
                        guardarShaderPref(pref, Variables.Barranca)
                        constantesTrabajadoresTiendasInicioFragmet.obtenerLocalida(Variables.Barranca)
                    }

                    Variables.Paramonga -> {
                        obtnerFiltrado(Variables.Paramonga)
                        guardarShaderPref(pref, Variables.Paramonga)
                        constantesTrabajadoresTiendasInicioFragmet.obtenerLocalida(Variables.Paramonga)
                    }

                    Variables.Pativilca -> {
                        obtnerFiltrado(Variables.Pativilca)
                        guardarShaderPref(pref, Variables.Pativilca)
                        constantesTrabajadoresTiendasInicioFragmet.obtenerLocalida(Variables.Pativilca)
                    }

                    Variables.General -> {
                        obtnerFiltrado(Variables.General)
                        guardarShaderPref(pref, Variables.General)
                        constantesTrabajadoresTiendasInicioFragmet.obtenerLocalida(Variables.General)
                    }

                    else -> {
                        println("Localidad no reconocida")
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        enviarCategoria()
        constantesTrabajadoresTiendasInicioFragmet.obtenerNombre_imgPerfil(
            binding.includeCabezero.usuarioRegsitradoName,
            mContex,
            binding.includeCabezero.imgPerfilUser
        )
        binding.verTiendas.setOnClickListener {
            val vista = Intent(mContex, TiendasGenerales::class.java)
            val filtrado =  binding.includeCabezero.filtradoUsuairo.text.toString()
            vista.putExtra(Variables.filtradoPasado, filtrado)
            startActivity(vista)
        }
    }

    private fun initScanner() {
        val integrator = IntentIntegrator.forSupportFragment(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
        integrator.setPrompt("Escanea un código QR")
        integrator.setCameraId(0)
        integrator.setBeepEnabled(false)
        integrator.setBarcodeImageEnabled(true)
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(requireContext(), "Escaneo cancelado", Toast.LENGTH_SHORT).show()
            } else {
                val db = FirebaseFirestore.getInstance()
                    .collection(Variables.trabajadores_usuariosDB)
                    .document(Variables.trabajadoresDB)
                    .collection(Variables.trabajadoresDB)
                    .document(result.contents)


                db.get().addOnSuccessListener { res ->
                    if (res.exists()) {
                        val data = res.data
                        val id = data?.get(Variables.id) as? String ?: ""

                        if (id == result.contents) {
                            val nombreUser = data?.get(Variables.nombre) as? String ?: ""
                            val nacionalidad = data?.get(Variables.nacionalidad) as? String ?: ""
                            val categoria = data?.get(Variables.categoriaTrabajo) as? String ?: ""
                            val img = data?.get(Variables.imagenPerfil) as? String ?: ""
                            val intent =
                                Intent(requireContext(),vistaTrabajador::class.java).apply {

                                    putExtra(Variables.id, result.contents)
                                    putExtra(Variables.nombreUSer, nombreUser)
                                    putExtra(Variables.nacionalidad, nacionalidad)
                                    putExtra(Variables.categoria, categoria)
                                    putExtra(Variables.imagenPerfil, img)
                                }

                            startActivity(intent)
                        } else {
                            Toast.makeText(
                                requireContext(),
                                "Trabajador no encontrado",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Documento no encontrado en la base de datos",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }.addOnFailureListener { exception ->
                    Toast.makeText(
                        requireContext(),
                        "Error al obtener datos: ${exception.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }


    private fun mostrarDatos(storedValue: String) {
        obtnerFiltrado(storedValue)
    }


    private fun guardarShaderPref(pref: SharedPreferences?, valor: String) {
        val editor = pref?.edit()
        editor?.putString(KEY, valor)
        editor?.apply()
    }


    private fun obtnerFiltrado(filtrado: String) {
        //Mejores trabajadores
        constantesTrabajadoresTiendasInicioFragmet.obtenerMejoresTrabajadores(listaTrabajo, filtrado, mContex, binding)
        // Trabajadores generales por categoría
        constantesTrabajadoresTiendasInicioFragmet.obtenerTrabajoscategoria(binding, filtrado, mContex)

    }

    private fun obtenerTrabajosCat() {
        binding.progresCargaCat.isVisible=true
        binding.RecicleCategoria.isVisible=false
        val trabajos = mutableListOf<dataClassCategoriasInicio>()
        val db = FirebaseFirestore.getInstance()
        val collection = db.collection(Variables.categoriasDB).document(Variables.categoriasTrabajo)
        collection.get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    val categorias = document.get(Variables.categoriasDB) as? ArrayList<String>
                    categorias?.let {
                        for (categoria in it) {
                            Log.d(Variables.categoriasDB, categoria)
                            constantesSubcategoriaszonasTiendas.obtenerImagenesCategorias(Variables.IMG_CategoriasGeneral,
                                Variables.categroriasTrabajadores,
                                categoria,
                                onSuccess = { urlImg ->
                                    val data = dataClassCategoriasInicio(
                                        categoria,
                                        urlImg ?: "",
                                    )
                                    binding.progresCargaCat.isVisible=false
                                    binding.RecicleCategoria.isVisible=true
                                    trabajos.add(data)
                                    inicalizarREciocle(
                                        binding.RecicleCategoria,
                                        trabajos
                                    )

                                },
                                onFailure = { error ->
                                    binding.progresCargaCat.isVisible=false
                                    binding.noEncontradocat.isVisible=true
                                    binding.RecicleCategoria.isVisible=false
                                    println("Error al obtener las imágenes para $categoria: ${error.message}")
                                    inicalizarREciocle(
                                        binding.RecicleCategoria,
                                        trabajos
                                    )
                                }
                            )
                        }
                        inicalizarREciocle(binding.RecicleCategoria, trabajos)
                    }
                } else {
                    Log.d(Variables.categoriasDB, "El documento no existe o está vacío.")
                }
            }
            .addOnFailureListener { exception ->
                Log.e(Variables.categoriasDB, "Error al obtener las categorías: $exception")
            }
    }

    private fun SetAnuncios() {
        constantesPublicidad.obtenerAnunciosGeinz(
            binding.carrusel,
            mContex,
            binding.includeCabezero.filtradoUsuairo
        )
        constantesPublicidad.obteneranunciostorage(binding.carruse2, binding.linealCaption, mContex)
        constantesPublicidad.obtenerAnunciosIniciosFragment(
            binding.IncludeAnunciosTercero.carrucel,
            mContex,
            Variables.anunciosTerceros
        )
        constantesPublicidad.obtenerAnunciosIniciosFragment(
            binding.IncludeAnunciosCuarto.carrucel,
            mContex,
            Variables.anunciosCuartos
        )
        constantesPublicidad.obtenerAnunciosIniciosFragment(
            binding.IncludeAnunciosQuinto.carrucel,
            mContex,
            Variables.anunciosQuintos
        )
        constantesPublicidad.obtenerAnunciosIniciosFragment(
            binding.IncludeAnunciosSexto.carrucel,
            mContex,
            Variables.anunciosSextos
        )
    }

    private fun enviarCategoria() {

        binding.verdesarrollo.setOnClickListener {
            iniciarVistaCategoriasT(
                binding.includeCabezero.filtradoUsuairo.text.toString(),
                Variables.Conductor_de_reparto
            )
        }
        binding.mejoresTrabajadeores.setOnClickListener {
            iniciarVistaCategoriasT( binding.includeCabezero.filtradoUsuairo.text.toString(), Variables.Mejores_Trabajadores)
        }
        binding.vermecanica.setOnClickListener {
            iniciarVistaCategoriasT( binding.includeCabezero.filtradoUsuairo.text.toString(), Variables.Servicios_de_Salud)
        }
        binding.verTrabajohogar.setOnClickListener {
            iniciarVistaCategoriasT( binding.includeCabezero.filtradoUsuairo.text.toString(), Variables.Construcción_y_hogar)
        }
        binding.vertrasnporte.setOnClickListener {
            iniciarVistaCategoriasT( binding.includeCabezero.filtradoUsuairo.text.toString(), Variables.Mecánicos)
        }
        binding.verTecnicos.setOnClickListener {
            iniciarVistaCategoriasT( binding.includeCabezero.filtradoUsuairo.text.toString(), Variables.Tecnicos)
        }
    }

    private fun iniciarVistaCategoriasT(filtrado: String, valor: String) {
        var intent = Intent(mContex, vista_CategoriasT::class.java)
        intent.putExtra(Variables.filtrado, filtrado)
        intent.putExtra(Variables.valor, valor)
        startActivity(intent)
    }

    private fun mandarvistaTrabajos(dataClassCategoriasInicio: dataClassCategoriasInicio) {
        var intent = Intent(mContex, vista_CategoriasT::class.java)
        intent.putExtra(Variables.valor, dataClassCategoriasInicio.cateogiria)
        startActivity(intent)
    }

    private fun inicalizarREciocle(
        recicleTrabajos: RecyclerView,
        lista: MutableList<dataClassCategoriasInicio>,
    ) {
        val recicle = recicleTrabajos
        recicle.layoutManager = LinearLayoutManager(mContex, LinearLayoutManager.HORIZONTAL, false)
        recicle.adapter = adapterTrabajosMostrados(lista) { dataClassCategoriasInicio ->
            mandarvistaTrabajos(dataClassCategoriasInicio)
        }
    }

    val permisoNotificaion =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { esConcedido -> }

    private fun obtenerImagenesFirestorage() {
        val db = FirebaseFirestore.getInstance().collection(Variables.anuncios)
            .document(Variables.anunciosprimarios_cortos).collection(Variables.anuncios)
        val lista = mutableListOf<CarouselItem>()

        db.get().addOnSuccessListener { res ->
            for (datos in res) {
                val data = datos.data
                val URLimg = data?.get(Variables.URLimg) as? String ?: ""
                val carouselItem = CarouselItem(URLimg)
                lista.add(carouselItem)
            }

            binding.carruselPimarioInicio.registerLifecycle(lifecycle)
            binding.carruselPimarioInicio.carouselListener = object : CarouselListener {
                override fun onCreateViewHolder(
                    layoutInflater: LayoutInflater,
                    parent: ViewGroup,
                ): ViewBinding? {
                    return ItemCustomPublicidadPrincipalBinding.inflate(
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
                    val currentBinding = binding as ItemCustomPublicidadPrincipalBinding

                    val currentItem = lista[position]
                    val currentData = res.documents[position].data
                    val currentTitulo = currentData?.get(Variables.titulo) as? String ?: ""
                    val currentDescripcion = currentData?.get(Variables.descripcion) as? String ?: ""
                    val currentURLimg = currentData?.get(Variables.URLimg) as? String ?: ""
                    val currentId = currentData?.get(Variables.id) as? String ?: ""

                    currentBinding.titulos.text = currentTitulo
                    currentBinding.descripcion.text = currentDescripcion
                    Glide.with(mContex)
                        .load(currentURLimg)
                        .into(currentBinding.imgPublicidad)
                    currentBinding.realtiveClikc.setOnClickListener {

                        val vista = Intent(mContex, oferta_principales_geinz::class.java).apply {
                            putExtra(Variables.idPublicidad, currentId)
                        }
                        startActivity(vista)

                    }
                }
            }
            binding.carruselPimarioInicio.setData(lista)

        }.addOnFailureListener { e ->
            println("Error al obtener los datos: $e")
        }

    }


}