package com.geinzz.geinzwork.constantesGeneral

import android.content.Context
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.geinzwork.constantesGeneral.constatnes_carga_imagenes_general
import com.geinzz.geinzwork.R
import com.geinzz.geinzwork.adapterViewholder.adapter
import com.geinzz.geinzwork.adapterViewholder.adapterCategorias
import com.geinzz.geinzwork.adapterViewholder.adapterTiendas
import com.geinzz.geinzwork.databinding.FragmentInicioFracmentBinding
import com.geinzz.geinzwork.databinding.ItemInicioFragmentUsersBinding
import com.geinzz.geinzwork.dataclass.dataClassTrabajosd
import com.geinzz.geinzwork.dataclass.dataclassTiendas
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import de.hdodenhof.circleimageview.CircleImageView

object constantesTrabajadoresTiendasInicioFragmet {

    private var img = ""
    private lateinit var firebaseAuth: FirebaseAuth

    fun obtenerMejoresTrabajadores(
        listaTrabajo: MutableList<dataClassTrabajosd>,
        filtrado: String,
        contexto: Context,
        binding: FragmentInicioFracmentBinding
    ) {
        val userCollections = FirebaseFirestore.getInstance()
            .collection("Trabajadores_Usuarios_Drivers")
            .document("trabajadores")
            .collection("trabajadores")

        actualizarVisibilidadCargando(true, binding, binding.loading)

        userCollections.get()
            .addOnSuccessListener { querySnapshot ->
                listaTrabajo.clear()

                val trabajadoresFiltrados = querySnapshot.documents.mapNotNull { document ->
                    val userData = document.data ?: return@mapNotNull null
                    val estrellas = userData["estrellas"] as? String
                    val estrellasInt = estrellas?.toIntOrNull()

                    if (estrellasInt != null && estrellasInt > 40) {
                        val usuario = dataClassTrabajosd(
                            id = userData["id"] as? String,
                            apellido = userData["apellido"] as? String,
                            c1 = userData["caracteristica1"] as? String,
                            c2 = userData["caracteristica2"] as? String,
                            c3 = userData["caracteristica3"] as? String,
                            categoria = userData["categoriaTrabajo"] as? String,
                            fecha_N = userData["fechaNac"] as? String,
                            genero = userData["genero"] as? String,
                            horarioam = userData["horario1"] as? String,
                            horariopm = userData["horario2"] as? String,
                            nacionalidad = userData["nacionalidad"] as? String,
                            nombre = userData["nombre"] as? String,
                            start = userData["estrellas"] as? String,
                            tipoT = userData["tipoTrabajo"] as? String,
                            localidad = userData["localidad"] as? String,
                            codigo = userData["codigo_pais"] as? String,
                            numero = userData["numero"] as? String,
                            imgpriamria = userData["imagenPerfil"] as? String,
                            activado = userData["activado"] as? String,
                            edadActual = userData["EdadActual"] as? String,
                            verificados = userData["verificado"] as? Boolean
                        )

                        // Verificar filtro
                        if (filtrado == "General" || usuario.localidad == filtrado) usuario else null
                    } else null
                }

                listaTrabajo.addAll(trabajadoresFiltrados)

                if (listaTrabajo.isNotEmpty()) {
                    binding.includeTrabajadoresTop.noEncontrado.isVisible = false
                    binding.includeTrabajadoresTop.trabajadores.isVisible = true
                    inicializarRecicleMejoresTrabajadores(
                        false,
                        listaTrabajo,
                        binding.includeTrabajadoresTop.trabajadores,
                        contexto
                    )
                } else {
                    binding.includeTrabajadoresTop.noEncontrado.isVisible = true
                    binding.includeTrabajadoresTop.trabajadores.isVisible = false
                }
                actualizarVisibilidadCargando(false, binding, binding.loading)
            }
            .addOnFailureListener {
                // Manejar error
                actualizarVisibilidadCargando(false, binding, binding.loading)
                binding.includeTrabajadoresTop.noEncontrado.isVisible = true
                binding.includeTrabajadoresTop.trabajadores.isVisible = false
            }
    }

    private fun actualizarVisibilidadCargando(
        cargando: Boolean,
        binding: FragmentInicioFracmentBinding,
        loadingView: LinearLayoutCompat
    ) {
        binding.includeTrabajadoresTop.progressvar.isVisible = cargando
        loadingView.isVisible = cargando
    }


    fun obtenerTrabajoscategoria(
        binding: FragmentInicioFracmentBinding,
        filtrado: String,
        contexto: Context,
    ) {
        // Inicializar listas por categoría
        val usuariosMedicina = mutableListOf<dataClassTrabajosd>()
        val usuariosTrabajoHogar = mutableListOf<dataClassTrabajosd>()
        val usauriosconductoresDelivery = mutableListOf<dataClassTrabajosd>()
        val usauriosMecanica = mutableListOf<dataClassTrabajosd>()
        val usuariosTecnicos = mutableListOf<dataClassTrabajosd>()

        // Obtener colección de usuarios de Firebase
        val userCollections = FirebaseFirestore.getInstance()
            .collection("Trabajadores_Usuarios_Drivers")
            .document("trabajadores")
            .collection("trabajadores")

        // Mostrar loading y ocultar los resultados
        binding.includeReciclemecanico.progressvar.isVisible = true
        binding.loading.isVisible = true
        binding.containerGeneral.isVisible = false

        // Limpiar las listas antes de empezar
        usuariosMedicina.clear()
        usuariosTrabajoHogar.clear()
        usauriosconductoresDelivery.clear()
        usauriosMecanica.clear()
        usuariosTecnicos.clear()

        // Obtener los datos de Firebase
        userCollections.get().addOnSuccessListener { querySnapshot ->
            var remainingQueries = querySnapshot.size()

            for (document in querySnapshot.documents) {
                val userData = document.data ?: continue
                val usuario = dataClassTrabajosd(
                    id = userData["id"] as? String,
                    apellido = userData["apellido"] as? String,
                    c1 = userData["caracteristica1"] as? String,
                    c2 = userData["caracteristica2"] as? String,
                    c3 = userData["caracteristica3"] as? String,
                    categoria = userData["categoriaTrabajo"] as? String,
                    fecha_N = userData["fechaNac"] as? String,
                    genero = userData["genero"] as? String,
                    horarioam = userData["horario1"] as? String,
                    horariopm = userData["horario2"] as? String,
                    nacionalidad = userData["nacionalidad"] as? String,
                    nombre = userData["nombre"] as? String,
                    start = userData["estrellas"] as? String,
                    tipoT = userData["tipoTrabajo"] as? String,
                    localidad = userData["localidad"] as? String,
                    codigo = userData["codigo_pais"] as? String,
                    numero = userData["numero"] as? String,
                    imgpriamria = userData["imagenPerfil"] as? String,
                    activado = userData["activado"] as? String,
                    edadActual = userData["EdadActual"] as? String,
                    verificados = userData["verificado"] as? Boolean
                )


                // Filtrar por localidad o "General"
                if (filtrado == usuario.localidad || filtrado == "General") {
                    when (usuario.categoria) {
                        "Servicios de Salud" -> usuariosMedicina.add(usuario)
                        "Construcción y hogar" -> usuariosTrabajoHogar.add(usuario)
                        "Conductor de reparto" -> usauriosconductoresDelivery.add(usuario)
                        "Tecnicos" -> usuariosTecnicos.add(usuario)
                        "Mecánicos" -> usauriosMecanica.add(usuario)
                    }
                }

                remainingQueries--

                // Al finalizar el procesamiento de todos los documentos
                if (remainingQueries == 0) {
                    // Inicializar los RecyclerView
                    inicializarTrabajos(
                        binding.includeRecicleViewsalud.trabajadores,
                        usuariosMedicina,
                        contexto
                    )
                    inicializarTrabajos(
                        binding.includeReciclehogar.trabajadores,
                        usuariosTrabajoHogar,
                        contexto
                    )
                    inicializarTrabajos(
                        binding.includeRecicleViewddelivery.trabajadores,
                        usauriosconductoresDelivery,
                        contexto
                    )
                    inicializarTrabajos(
                        binding.includeRecicleTecnicos.trabajadores,
                        usuariosTecnicos,
                        contexto
                    )
                    inicializarTrabajos(
                        binding.includeReciclemecanico.trabajadores,
                        usauriosMecanica,
                        contexto
                    )

                    // Actualizar visibilidad de las secciones basadas en si hay datos o no
                    actualizarVisibilidadPorCategoria(
                        binding.includeRecicleViewsalud,
                        usuariosMedicina
                    )
                    actualizarVisibilidadPorCategoria(
                        binding.includeReciclehogar,
                        usuariosTrabajoHogar
                    )
                    actualizarVisibilidadPorCategoria(
                        binding.includeRecicleViewddelivery,
                        usauriosconductoresDelivery
                    )
                    actualizarVisibilidadPorCategoria(
                        binding.includeRecicleTecnicos,
                        usuariosTecnicos
                    )
                    actualizarVisibilidadPorCategoria(
                        binding.includeReciclemecanico,
                        usauriosMecanica
                    )

                    // Ocultar loading y mostrar los resultados
                    actualizarVisibilidad(true, binding.loading, binding.containerGeneral)
                }
            }
        }.addOnFailureListener {
            // En caso de error
            binding.loading.isVisible = false
            binding.includeReciclemecanico.noEncontrado.isVisible = true
        }
    }

    fun actualizarVisibilidadPorCategoria(
        sectionView: ItemInicioFragmentUsersBinding,
        usuarios: List<dataClassTrabajosd>
    ) {
        if (usuarios.isEmpty()) {
            sectionView.noEncontrado.isVisible = true
            sectionView.progressvar.isVisible = false
        } else {
            sectionView.noEncontrado.isVisible = false
            sectionView.trabajadores.isVisible = true
        }
    }


    private fun actualizarVisibilidad(
        hayArticulos: Boolean,
        carga: LinearLayoutCompat,
        container: FrameLayout
    ) {
        carga.isVisible = false
        if (hayArticulos) {
            container.isVisible = true
            carga.isVisible = false
        } else {
            carga.isVisible = true
            container.isVisible = false
        }
    }


    fun inicializarTrabajos(
        recicleTrabajadores: RecyclerView,
        listaTrabajos: MutableList<dataClassTrabajosd>,
        contexto: Context
    ) {
        firebaseAuth = FirebaseAuth.getInstance()
        val recicle = recicleTrabajadores
        recicle.layoutManager = LinearLayoutManager(contexto, LinearLayoutManager.HORIZONTAL, false)
        recicle.adapter = adapterCategorias(
            listaTrabajos,
            { dataClassTrabajosd -> constantes.vistaTrabajador(contexto, dataClassTrabajosd) },
            firebaseAuth.uid.toString()
        )
    }

    fun inicializarRecicleMejoresTrabajadores(
        onBackPresser: Boolean,
        listaTrabajos: MutableList<dataClassTrabajosd>,
        recicle: RecyclerView,
        contexto: Context
    ) {
        firebaseAuth = FirebaseAuth.getInstance()

        val listaAleatoria = listaTrabajos.shuffled().toMutableList()

        recicle.layoutManager = LinearLayoutManager(contexto, LinearLayoutManager.HORIZONTAL, false)
        recicle.adapter = adapter(
            onBackPresser,
            listaAleatoria,
            firebaseAuth.uid.toString(),
            4
        )
    }


    fun obtenerNombre_imgPerfil(
        progressbar: CircularProgressIndicator,
        TextView: TextView,
        contexto: Context,
        imagen: CircleImageView
    ) {
        if (constantes.firebaseAuth.currentUser == null) {
            val placeholderperfil =
                ContextCompat.getDrawable(contexto, R.drawable.img_perfil)
            TextView.text = "usuario"
            constatnes_carga_imagenes_general.changer_img(
                progressbar,
                contexto,
                img,
                imagen,
                null,
                "perfil", placeholderperfil
            )
        } else {
            var encontrado = false
            val db = FirebaseFirestore.getInstance().collection("Trabajadores_Usuarios_Drivers")
                .document("trabajadores").collection("trabajadores")

            db.get().addOnSuccessListener { res ->
                for (resultado in res) {
                    val data = resultado.data
                    val id = data?.get("id") as? String
                    if (id == constantes.firebaseAuth.uid.toString()) {
                        encontrado = true
                        setearimgNombre(
                            progressbar,
                            "trabajadores",
                            id.toString(),
                            TextView,
                            contexto,
                            imagen
                        )
                        break
                    }
                }
                if (encontrado == false) {
                    val db2 =
                        FirebaseFirestore.getInstance().collection("Trabajadores_Usuarios_Drivers")
                            .document("usuarios").collection("usuarios")

                    db2.get().addOnSuccessListener { res2 ->
                        for (resultado in res2) {
                            val data = resultado.data
                            val id = data?.get("id") as? String
                            if (id == constantes.firebaseAuth.uid.toString()) {
                                setearimgNombre(
                                    progressbar,
                                    "usuarios",
                                    id.toString(),
                                    TextView,
                                    contexto,
                                    imagen
                                )
                                break
                            }
                        }
                    }
                }
            }
        }
    }

    private fun setearimgNombre(
        progressbar: CircularProgressIndicator,
        referencia: String,
        id: String,
        TextView: TextView,
        contexto: Context,
        imagen: CircleImageView
    ) {
        FirebaseFirestore.getInstance().collection("Trabajadores_Usuarios_Drivers")
            .document(referencia).collection(referencia).document(id)
            .get().addOnSuccessListener { res ->
                if (res.exists()) {
                    val data = res.data
                    val nombre = data?.get("nombre") as? String ?: ""
                    val imagenPerfil = data?.get("imagenPerfil") as? String ?: ""
                    TextView.text = nombre

                    val placeholderperfil =
                        ContextCompat.getDrawable(contexto, R.drawable.img_perfil)

                    if (imagenPerfil == "") {
                        constatnes_carga_imagenes_general.changer_img(
                            progressbar,
                            contexto,
                            imagenPerfil,
                            imagen,
                            null,
                            "perfil",
                            placeholderperfil
                        )
                    } else {
                        constatnes_carga_imagenes_general.changer_img(
                            progressbar,
                            contexto,
                            imagenPerfil,
                            imagen,
                            null,
                            "perfil",
                            placeholderperfil // Usa el placeholder también en el else
                        )
                    }
                }
            }
    }


    fun obtenerTiendas(filtrado: String, contexto: Context, recicleTiendas1: RecyclerView) {

        val listaTiendas = mutableListOf<dataclassTiendas>()
        val dbinstace = FirebaseFirestore.getInstance().collection("Tiendas")
        dbinstace.get()
            .addOnSuccessListener { querySnapshot ->
                for (datos in querySnapshot) {
                    val userData = datos.data
                    val localidad = userData?.get("localidad") as? String

                    val categoria = userData?.get("categoria") as? String
                    val estrellas = userData?.get("estrellas") as? String
                    val horario = userData?.get("horario") as? String
                    val id = userData?.get("id") as? String
                    val imgPerfil = userData?.get("imgPerfil") as? String
                    val imgPortada = userData?.get("imgPortada") as? String
                    val nombre = userData?.get("nombre") as? String
                    val numero = userData?.get("numero") as? String
                    val seguidores = userData?.get("seguidores") as? String
                    val ubicacion = userData?.get("ubicacion") as? String
                    val estado = userData?.get("estado") as? String
                    val slogan = userData?.get("slogan") as? String
                    val tiendas = dataclassTiendas(
                        categoria,
                        estrellas,
                        horario,
                        id,
                        imgPerfil,
                        imgPortada,
                        nombre,
                        numero,
                        seguidores,
                        ubicacion, estado, slogan, localidad
                    )
                    if (localidad == filtrado) {
                        listaTiendas.add(tiendas)
                    } else if (filtrado == "General") {
                        listaTiendas.add(tiendas)
                    } else {

                    }
                }
                RecicleTiendas(listaTiendas, recicleTiendas1, contexto)
            }
    }

    private fun RecicleTiendas(

        listaTiendas: MutableList<dataclassTiendas>,
        recicleTiendas1: RecyclerView,
        contexto: Context
    ) {
        firebaseAuth = FirebaseAuth.getInstance()
        val recicle = recicleTiendas1
        recicle.layoutManager = LinearLayoutManager(contexto, LinearLayoutManager.HORIZONTAL, false)
        recicle.adapter = adapterTiendas(
            listaTiendas,
            { dataclassTiendas -> constantes2.seguirTienda(dataclassTiendas, contexto) },
            { dataclassTiendas -> constantes2.dejarDeSeguir(dataclassTiendas, contexto) },
            { dataclassTiendas -> constantes2.verMasInfoTienda(dataclassTiendas, contexto) },
            contexto,
            firebaseAuth.uid.toString()
        )
    }

    var localidads = ""
    fun obtenerLocalida(localidad: String) {
        println("Obteniendo la localidad: $localidad")
        localidads = localidad
    }

    fun obtenerNumeroTiendas(idTienda: String, numero: (String) -> Unit) {
        val db = FirebaseFirestore.getInstance().collection("Tiendas").document(idTienda)
        db.get().addOnSuccessListener { res ->
            if (res.exists()) {
                val data = res.data
                val numero = data?.get("numero") as? String
                numero(numero.toString())
            }
        }
            .addOnFailureListener { e ->
                println("error al encontral el numero de la tienda")
            }
    }
}