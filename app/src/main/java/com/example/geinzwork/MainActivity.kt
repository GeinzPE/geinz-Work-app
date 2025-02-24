package com.geinzz.geinzwork

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.WindowInsets
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.geinzwork.constantesGeneral.constantes_agregar_estadisticas_publicaiones
import com.example.geinzwork.oferta_principales_geinz
import com.geinzz.geinzwork.constantesGeneral.constantesPublicidad
import com.geinzz.geinzwork.databinding.ActivityMainBinding
import com.geinzz.geinzwork.databinding.BottomSheetMostrarProductosBinding
import com.geinzz.geinzwork.databinding.BottomShettCambiosRealizadosBinding
import com.geinzz.geinzwork.fragmentos.categoriasFracment
import com.geinzz.geinzwork.fragmentos.contactoFracment
import com.geinzz.geinzwork.fragmentos.cuentaFracment
import com.geinzz.geinzwork.fragmentos.inicioFracment
import com.geinzz.geinzwork.fragmentos.sinInternet
import com.geinzz.geinzwork.fragmentos.sinRegistroFracment
import com.geinzz.geinzwork.vistaTiendas.TiendasGenerales
import com.geinzz.geinzwork.vistaTiendas.VistaTienda
import com.geinzz.geinzwork.vistaTiendas.vistaProductosGeneralTiendas
import com.geinzz.geinzwork.vistaTrabajador.ver_detalles_Promociones
import com.geinzz.geinzwork.vistaTrabajador.vistaTrabajador
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDragHandleView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings

class MainActivity : AppCompatActivity(), View.OnApplyWindowInsetsListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private var currentFragmentTag: String? = null
    private var isUpdatingBottomNavigation = false
    private lateinit var dialog: BottomSheetDialog
    private lateinit var bottomSheet: BottomSheetDragHandleView
    private lateinit var bindingbottomShet: BottomShettCambiosRealizadosBinding

    private lateinit var remoteConfig: FirebaseRemoteConfig

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        remoteConfig = FirebaseRemoteConfig.getInstance()
        firebaseAuth = FirebaseAuth.getInstance()
        binding.VistaTiendas.setOnClickListener {
            startActivity(Intent(this, TiendasGenerales::class.java))
        }
        val storyId = intent.getStringExtra("story_id")
        if (storyId != null) {
            println("ID del story recibido en la actividad: $storyId")
        }
        hideNavigationBar()
        FirebaseDynamicLinks.getInstance()
            .getDynamicLink(intent)
            .addOnSuccessListener(this) { pendingDynamicLinkData ->
                val deepLink: Uri? = pendingDynamicLinkData?.link
                if (deepLink != null) {
                    val idPublicidadPrimaria = deepLink.getQueryParameter("idDocumento")
                    val idAnuncio = deepLink.getQueryParameter("idAnuncio")
                    val storeId = deepLink.getQueryParameter("id")
                    val anunciosPrimarios = deepLink.getQueryParameter("idAnuncioPrimarioGeinz")
                    val userId = deepLink.getQueryParameter("idTienda")
                    val ArticiculoClikado = deepLink.getQueryParameter("idArticulo")
                    val idTiendaSeleccionada = deepLink.getQueryParameter("idTiendaSeleccionada")
                    val idTrabajadorGeinz = deepLink.getQueryParameter("idTrabajadorGeinz")


                    when {
                        idPublicidadPrimaria != null && idAnuncio != null -> openPublicidadPrimaria(
                            idPublicidadPrimaria,
                            idAnuncio
                        )

                        idTrabajadorGeinz != null -> openVistaTrabajador(idTrabajadorGeinz)
                        anunciosPrimarios != null -> openAnunciosPrimarios(anunciosPrimarios)
                        storeId != null -> openPublicidad(storeId)
                        userId != null -> openPerfilTienda(userId)
                        ArticiculoClikado != null && idTiendaSeleccionada != null -> openArticuloTienda(
                            ArticiculoClikado, idTiendaSeleccionada
                        )

                        else -> println("No se encontraron parámetros válidos en el enlace")
                    }
                }
            }
            .addOnFailureListener(this) {
                println("No se encontró el enlace dinámico: $it")
            }
        changeSystemBarsColor(Color.parseColor("#744ACB"))
        if (!isInternetAvailable(this)) {
            Toast.makeText(this, "No hay conexión a Internet", Toast.LENGTH_SHORT).show()
            sinInternetfun()
        } else {
            loadMainContent()
        }
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(3600) // Fetch cada hora
            .build()
        remoteConfig.setConfigSettingsAsync(configSettings)
        // Fetch y activar los valores de Remote Config
        remoteConfig.fetchAndActivate()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val versionMasReciente = remoteConfig.getString("latest_version")
                    val url_playStore = remoteConfig.getString("urlPlayStore")
                    println("obtenemos la version mas reciente $versionMasReciente")
                    verificarVersion(url_playStore, versionMasReciente)
                } else {
                    println("error al obtener la version")
                }
            }

        intent?.let {
            if (it.hasExtra("target")) {
                val target = it.getStringExtra("target")
                if (target == "new_version_section") {
                    openNewVersionSection()
                }
            }
        }
    }

    private fun openVistaTrabajador(idTrabajadorGeinz: String) {
        val userCollections =
            FirebaseFirestore.getInstance().collection("Trabajadores_Usuarios_Drivers")
                .document("trabajadores").collection("trabajadores").document(idTrabajadorGeinz)
        val db = FirebaseFirestore.getInstance().collection("solicitudes_servicios")
            .document("verificaciones").collection("activos").document(idTrabajadorGeinz)
        constantesPublicidad.obtenerLocalidaGeneroTipoCuenta(db, "verificacion")

        userCollections.get().addOnSuccessListener { res ->
            if (res.exists()) {
                val data = res.data
                val imperfil = data?.get("imagenPerfil") as? String ?: ""
                val nombre = data?.get("nombre") as? String ?: ""
                val nacionalidad = data?.get("nacionalidad") as? String ?: ""
                val categoria = data?.get("categoriaTrabajo") as? String ?: ""
                val id = data?.get("id") as? String ?: ""

                val vista = Intent(this, vistaTrabajador::class.java).apply {
                    putExtra("id", id)
                    putExtra("nombreUSer", nombre)
                    putExtra("nacionalidad", nacionalidad)
                    putExtra("categoria", categoria)
                    putExtra("imagenPerfil", imperfil)
                }
                startActivity(vista)

            }
        }.addOnFailureListener { e ->
            Log.e("error", "error al obtener los datos")
        }


    }

    var nombreUsuario = ""
    var id = ""

    private fun openNewVersionSection() {
        val intent = Intent(this, vistas_anuncios_general::class.java)
        startActivity(intent)
    }

    private fun verificarVersion(urlPlayStore: String, versionMasReciente: String) {
        val versionActual = packageManager.getPackageInfo(packageName, 0).versionName
        val sharedPreferences = getSharedPreferences("app_preferences", MODE_PRIVATE)
        val versionGuardada = sharedPreferences.getString("ultima_version", "")
        if (versionActual < versionMasReciente) {
            AlertDialog.Builder(this)
                .setTitle("Actualización disponible")
                .setMessage("Hay una nueva versión de la aplicación disponible. Actualiza para disfrutar de las últimas mejoras.")
                .setPositiveButton("Actualizar") { dialog, which ->
                    val intent = Intent(Intent.ACTION_VIEW).apply {
                        data = Uri.parse(urlPlayStore)
                    }
                    if (intent.resolveActivity(packageManager) != null) {
                        startActivity(intent)
                    } else {
                        println("No hay una aplicación disponible para abrir la URL de actualización.")
                    }
                }
                .setNegativeButton("Más tarde", null)
                .show()
        } else if (versionActual > versionGuardada!!) {
            dialog = BottomSheetDialog(this)
            dialogControlVersiones(versionMasReciente)
            dialog.show()
            with(sharedPreferences.edit()) {
                putString("ultima_version", versionActual)
                apply()
            }
        }
    }

    private fun dialogControlVersiones(versionMasReciente: String) {
        bindingbottomShet = BottomShettCambiosRealizadosBinding.inflate(LayoutInflater.from(this))
        val view = bindingbottomShet.root
        bottomSheet = view.findViewById(R.id.cerrar)
        val db = FirebaseFirestore.getInstance().collection("controVersiones").document("control")

        db.get().addOnSuccessListener { res ->
            if (res.exists()) {
                val data = res.data
                val texto = data?.get("texto") as? String ?: ""
                if (texto.isNotEmpty()) {
                    val formattedText = Html.fromHtml(texto, Html.FROM_HTML_MODE_COMPACT)
                    bindingbottomShet.versionActual.text = versionMasReciente
                    bindingbottomShet.textoCambiosRealiazdos.text = formattedText

                    // Mostrar el diálogo después de cargar y configurar el texto
                    dialog.setContentView(view)
                    dialog.show()
                }
            }
        }
            .addOnFailureListener { e ->
                Toast.makeText(
                    this,
                    "No se pudo encontrar los cambios de la nueva versión",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }


    private fun hideNavigationBar() {
        window.decorView.apply {
            systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_IMMERSIVE
                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    )
        }
    }

    private fun openPublicidad(storeId: String?) {
        val db = FirebaseFirestore.getInstance().collection("noticias").document(storeId!!)
        storeId?.let {
            val intent = Intent(this, ver_detalles_Promociones::class.java).apply {
                constantesPublicidad.agregarCantidadClickAnuncios(db, "", "click")
                putExtra("idAnuncio", it)
                putExtra("entrada", "noticia")
            }
            startActivity(intent)
        }
    }


    private fun openAnunciosPrimarios(id: String?) {
        id?.let {
            val intent = Intent(this, oferta_principales_geinz::class.java).apply {
                putExtra("idPublicidad", it)
            }
            startActivity(intent)
        }
    }

    private fun openPerfilTienda(storeId: String?) {
        storeId?.let {
            val intent = Intent(this, VistaTienda::class.java).apply {
                putExtra("idTienda", it)
            }
            startActivity(intent)
        }
    }

    private fun openArticuloTienda(idProducto: String?, idtienda: String?) {
        val intent = Intent(this, vistaProductosGeneralTiendas::class.java).apply {
            putExtra("idProductoClikado", idProducto)
            putExtra("idTienda", idtienda)
        }
        startActivity(intent)
    }

    private fun openPublicidadPrimaria(idPublicidadPrimaria: String?, idAnuncio: String?) {
        val db =
            FirebaseFirestore.getInstance().collection("anuncios").document(idPublicidadPrimaria!!)
                .collection("anuncios").document(idAnuncio!!)
        constantesPublicidad.agregarCantidadClickAnuncios(
            db,
            idAnuncio.toString(),
            "Clicks"
        )
        val intent = Intent(this, vistas_anuncios_general::class.java).apply {
            putExtra("docuemnto", idPublicidadPrimaria)
            putExtra("anuncio", idAnuncio)
        }
        startActivity(intent)

    }

    private fun changeSystemBarsColor(color: Int) {
        window.navigationBarColor = color
        window.statusBarColor = color
    }

    fun onInternetRestored() {
        val fragment = supportFragmentManager.findFragmentByTag("sin_internet")
        fragment?.let {
            supportFragmentManager.beginTransaction().remove(it).commit()
        }
        loadMainContent()
    }

    private fun loadMainContent() {
        verinicio()

        binding.buttonNavigation.setOnItemSelectedListener { item ->
            if (isUpdatingBottomNavigation) return@setOnItemSelectedListener true // Evita cambios mientras se actualiza
            when (item.itemId) {
                R.id.inicio -> {
                    if (currentFragmentTag != "FragmentInicio") {
                        verinicio()
                    }
                    true
                }

                R.id.Contacto -> {
                    if (currentFragmentTag != "FragmentContacto") {
                        vercontacto()
                    }
                    true
                }

                R.id.Categorias -> {
                    if (currentFragmentTag != "FragmentCategorias") {
                        vercategoria()
                    }
                    true
                }

                R.id.Cuenta -> {
                    if (currentFragmentTag != "FragmentCuenta") {
                        vercuenta()
                    }
                    true
                }



                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment, tag: String) {
        currentFragmentTag = tag
        supportFragmentManager.beginTransaction()
            .replace(R.id.fracmentoLayaout, fragment, tag)
            .commit()
    }

    override fun onBackPressed() {
        if (currentFragmentTag == "FracmentInicio") {
            super.onBackPressed()
        } else {
            verinicio()
        }
    }

    private fun updateBottomNavigation(selectedItemId: Int) {
        isUpdatingBottomNavigation = true
        binding.buttonNavigation.selectedItemId = selectedItemId
        isUpdatingBottomNavigation = false
    }

    private fun isInternetAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork ?: return false
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
            return when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            @Suppress("DEPRECATION")
            val networkInfo = connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")
            return networkInfo.isConnected
        }
    }


    val bundle = Bundle().apply {
        putString("clave", "$nombreUsuario")
        putString("idUSer", "$id")
    }

    private fun sinInternetfun() {
        val fragmentBinding = sinInternet()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fracmentoLayaout.id, fragmentBinding, "sin_internet")
        fragmentTransaction.commit()
    }

    private fun verinicio() {
        var fracmentBinding = inicioFracment()
        fracmentBinding.arguments = bundle
        val fracmentTrasition = supportFragmentManager.beginTransaction()
        fracmentTrasition.replace(binding.fracmentoLayaout.id, fracmentBinding, "FracmentInicio")
        replaceFragment(inicioFracment(), "FracmentInicio")
        fracmentTrasition.commit()
        updateBottomNavigation(R.id.inicio)

    }

    private fun vercontacto() {
        var fracmentBinding = contactoFracment()
        val fracmentTrasition = supportFragmentManager.beginTransaction()
        fracmentTrasition.replace(binding.fracmentoLayaout.id, fracmentBinding, "contactoFracment")
        replaceFragment(contactoFracment(), "FragmentContacto")
        fracmentTrasition.commit()
        updateBottomNavigation(R.id.Contacto)
    }

    private fun vercategoria() {
        var fracmentBinding = categoriasFracment()
        val fracmentTrasition = supportFragmentManager.beginTransaction()
        fracmentTrasition.replace(
            binding.fracmentoLayaout.id,
            fracmentBinding,
            "categoriasFracment"
        )
        replaceFragment(categoriasFracment(), "FragmentCategorias")
        fracmentTrasition.commit()
        updateBottomNavigation(R.id.Categorias)

    }

    private fun vercuenta() {
        if (firebaseAuth.currentUser == null) {
            var fracmentBinding = sinRegistroFracment()
            val transition = supportFragmentManager.beginTransaction()
            transition.replace(binding.fracmentoLayaout.id, fracmentBinding, "sin registro")
            replaceFragment(sinRegistroFracment(), "FragmentCuenta")
            transition.commit()
        } else {
            var fracmentBinding = cuentaFracment()
            val fracmentTrasition = supportFragmentManager.beginTransaction()
            fracmentTrasition.replace(
                binding.fracmentoLayaout.id,
                fracmentBinding,
                "cuentaFracment"
            )
            replaceFragment(cuentaFracment(), "cuentaFracment")
            fracmentTrasition.commit()
        }
        updateBottomNavigation(R.id.Cuenta)
    }

    override fun onApplyWindowInsets(v: View, insets: WindowInsets): WindowInsets {
        TODO("Not yet implemented")
    }

}