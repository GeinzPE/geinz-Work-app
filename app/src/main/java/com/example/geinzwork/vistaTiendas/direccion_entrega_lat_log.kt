package com.geinzz.geinzwork.vistaTiendas

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.geinzwork.dataclass.dataClass_ubicacion_user
import com.geinzz.geinzwork.R
import com.geinzz.geinzwork.databinding.ActivityDireccionEntregaLatLogBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class direccion_entrega_lat_log : AppCompatActivity() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var binding: ActivityDireccionEntregaLatLogBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private val LOCATION_PERMISSION_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDireccionEntregaLatLogBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        firebaseAuth = FirebaseAuth.getInstance()
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        mostrarDialog()
        val nombreColeccion = binding.nombreColeccionED
        obtenerUbicaciones(firebaseAuth.uid.toString())
        binding.obtenerLocalizacion.setOnClickListener {
            getLocation { completado ->
                if (completado) {
                    Toast.makeText(
                        this,
                        "latitud y longitud obtenida correctamente",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this,
                        "error al obtener la latitud y longitud",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }
        }
        binding.crear.setOnClickListener {
            binding.containerSinUBI.isVisible = false
            binding.editar.isVisible = false
            binding.linealForm.isVisible = true
            nombreColeccion.isEnabled = true
            val nombreColeccion = nombreColeccion.text.toString()
            val direccion = binding.direccion.text.toString()
            val direccionCasa = binding.direccionCasaED.text.toString()
            val referencia = binding.referenciaED.text.toString()

            if (binding.crear.text.toString().equals("crear", ignoreCase = true)) {
                if (nombreColeccion.isEmpty() || direccion.isEmpty() || direccionCasa.isEmpty() || referencia.isEmpty()) {
                    if (nombreColeccion.isEmpty()) binding.nombreColeccionED.error =
                        "Este campo es obligatorio"
                    if (direccion.isEmpty()) binding.direccion.error =
                        "Este campo es obligatorio"
                    if (direccionCasa.isEmpty()) binding.direccionCasaED.error =
                        "Este campo es obligatorio"
                    if (referencia.isEmpty()) binding.referenciaED.error =
                        "Este campo es obligatorio"
                } else {
                    agregaDireccionUsuario(false, firebaseAuth.uid.toString())
                }
            } else {
                binding.editar.isVisible = false
                binding.crear.text = "crear"
                binding.nombreColeccionED.setText("")
                binding.direccion.setText("")
                binding.direccionCasaED.setText("")
                binding.referenciaED.setText("")
                binding.latitudUSer.text = ""
                binding.longituduser.text = ""
            }


        }
        binding.editar.setOnClickListener {
            agregaDireccionUsuario(
                true,
                firebaseAuth.uid.toString(),
                binding.idReferencia.text.toString()
            )
            binding.crear.isVisible = true
        }

        binding.eliminar.setOnClickListener {
            eliminarReferencia(
                binding.collectionEcontrado.text.toString(),
                firebaseAuth.uid.toString(),
                binding.idReferencia.text.toString()
            )
        }

        binding.listaUbicaciones.setOnItemClickListener { parent, view, position, id ->
            val ubicacion = parent.getItemAtPosition(position) as dataClass_ubicacion_user
            val log = ubicacion.log
            val lat = ubicacion.lat
            val direccion = ubicacion.direccion
            val id = ubicacion.id
            val referencia = ubicacion.referencia
            val nombreColeccion = ubicacion.nombreC
            binding.crear.isVisible = false
            binding.linealForm.isVisible = true
            binding.nombreColeccionED.setText(nombreColeccion)
            binding.nombreColeccionED.isEnabled = false
            binding.direccion.setText("$lat,$log")
            binding.latitudUSer.text = lat
            binding.longituduser.text = log
            binding.direccionCasaED.setText(direccion)
            binding.referenciaED.setText(referencia)
            binding.editar.isVisible = true
            binding.idReferencia.text = id.toString()
            binding.eliminar.isVisible = true
        }

    }

    private fun eliminarReferencia(coleccion_one: String, idUSer: String, documento: String) {
        val instance = FirebaseFirestore.getInstance()
        val dbTrabajador = instance.collection("Trabajadores_Usuarios_Drivers")
            .document(coleccion_one).collection(coleccion_one).document(idUSer)
            .collection("ubicacion").document(documento)
        dbTrabajador.delete().addOnSuccessListener { res ->
            obtenerUbicaciones(idUSer)
            Toast.makeText(this, "ubicacion eliminada correctamente", Toast.LENGTH_SHORT).show()
            binding.linealForm.isVisible = false
            binding.linealBtnELiminarEditar.isVisible = false
            binding.crear.isVisible = true
        }
            .addOnFailureListener { e ->
                Toast.makeText(this, "error al eliminar la ubicacion", Toast.LENGTH_SHORT).show()
            }
    }

    private fun agregaDireccionUsuario(editar: Boolean, id: String, idRef: String? = null) {
        val instance = FirebaseFirestore.getInstance()
        val dbTrabajador = instance.collection("Trabajadores_Usuarios_Drivers")
            .document("trabajadores").collection("trabajadores").document(id)
        val dbUsuario = instance.collection("Trabajadores_Usuarios_Drivers")
            .document("usuarios").collection("usuarios").document(id)
        var encontrado = false

        dbTrabajador.get().addOnSuccessListener { res ->
            if (res.exists()) {
                encontrado = true
                agregarUbicacion(editar, "trabajadores", "trabajadores", id, idRef)
                Log.d("encontrado", "Documento encontrado en trabajadores")
            }
            dbUsuario.get().addOnSuccessListener { res ->
                if (res.exists()) {
                    encontrado = true
                    agregarUbicacion(editar, "usuarios", "usuarios", id, idRef)
                    Log.d("encontrado", "Documento encontrado en usuarios")
                }

                if (!encontrado) {
                    Log.d("encontrado", "Documento no encontrado en ninguna colección")
                }
            }.addOnFailureListener { e ->
                Log.d("encontrado", "Error al buscar en usuarios: ${e.message}")
            }
        }.addOnFailureListener { e ->
            Log.d("encontrado", "Error al buscar en trabajadores: ${e.message}")
        }
    }

    private fun obtenerUbicaciones(id: String) {
        val instance = FirebaseFirestore.getInstance()
        val dbTrabajador = instance.collection("Trabajadores_Usuarios_Drivers")
            .document("trabajadores").collection("trabajadores").document(id)
        val dbUsuario = instance.collection("Trabajadores_Usuarios_Drivers")
            .document("usuarios").collection("usuarios").document(id)
        var encontrado = false

        dbTrabajador.collection("ubicacion").get().addOnSuccessListener { result ->
            if (!result.isEmpty) {
                encontrado = true
                val ubicaciones = mutableListOf<dataClass_ubicacion_user>()
                for (document in result) {
                    val log = document.getString("log") ?: "No disponible"
                    val lat = document.getString("lat") ?: "No disponible"
                    val direccion = document.getString("direccion") ?: "No disponible"
                    val id = document.getString("id") ?: "No disponible"
                    val referencia = document.getString("referencia") ?: "No disponible"
                    val nombreC = document.getString("nombre") ?: "No disponible"
                    val ubicacion =
                        dataClass_ubicacion_user(log, lat, direccion, id, referencia, nombreC)
                    ubicaciones.add(ubicacion)
                }
                mostrarUbicaciones(ubicaciones)
                binding.collectionEcontrado.text = "trabajadores"
                Log.d("econtrado", "Ubicaciones encontradas en trabajadores")

            } else {
                dbUsuario.collection("ubicacion").get().addOnSuccessListener { result ->
                    if (!result.isEmpty) {
                        encontrado = true
                        val ubicaciones = mutableListOf<dataClass_ubicacion_user>()
                        for (document in result) {
                            val log = document.getString("log") ?: "No disponible"
                            val lat = document.getString("lat") ?: "No disponible"
                            val direccion = document.getString("direccion") ?: "No disponible"
                            val idRefencia = document.getString("id") ?: "No disponible"
                            val referencia = document.getString("referencia") ?: "No disponible"
                            val nombreC = document.getString("nombre") ?: "No disponible"
                            val ubicacion = dataClass_ubicacion_user(
                                log,
                                lat,
                                direccion,
                                idRefencia,
                                referencia,
                                nombreC
                            )
                            ubicaciones.add(ubicacion)
                        }
                        mostrarUbicaciones(ubicaciones)
                        binding.collectionEcontrado.text = "usuarios"
                        Log.d("econtrado", "Ubicaciones encontradas en usuarios")
                        binding.containerSinUBI.isVisible = false
                    }
                    if (!encontrado) {
                        Log.d("econtrado", "No se encontraron ubicaciones en ninguna colección")
                        binding.containerSinUBI.isVisible = true
                    }
                }.addOnFailureListener { e ->
                    Log.d("econtrado", "Error al buscar en usuarios: ${e.message}")
                    binding.containerSinUBI.isVisible = true
                }
            }
        }.addOnFailureListener { e ->
            Log.d("econtrado", "Error al buscar en trabajadores: ${e.message}")
            binding.containerSinUBI.isVisible = true
        }
    }


    private fun mostrarUbicaciones(ubicaciones: List<dataClass_ubicacion_user>) {
        if (ubicaciones.isEmpty()) {
            binding.listaUbicaciones.isVisible = false
        } else {
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, ubicaciones)
            binding.listaUbicaciones.adapter = adapter
            binding.listaUbicaciones.isVisible = true
        }
    }


    private fun mostrarDialog() {
        binding.nombreColecciones.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(getString(R.string.nombreCollectioTitle))
            builder.setMessage(getString(R.string.nombreCollection))
            builder.setPositiveButton(getString(R.string.dialog_positive)) { dialog, _ -> dialog.dismiss() }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

        binding.infoCasa.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(getString(R.string.nombrerefUNOTitle))
            builder.setMessage(getString(R.string.nombrerefUNO))
            builder.setPositiveButton(getString(R.string.dialog_positive)) { dialog, _ -> dialog.dismiss() }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

        binding.infoRef.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(getString(R.string.nombrerefDOSTitle))
            builder.setMessage(getString(R.string.nombrerefDOS))
            builder.setPositiveButton(getString(R.string.dialog_positive)) { dialog, _ -> dialog.dismiss() }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }

    private fun agregarUbicacion(
        editar: Boolean,
        doc1: String,
        doc2: String,
        id: String,
        idRefCreado: String? = null
    ) {
        val db = FirebaseFirestore.getInstance()
            .collection("Trabajadores_Usuarios_Drivers")
            .document(doc1)
            .collection(doc2)
            .document(id)
            .collection("ubicacion")

        if (editar) {
            db.get().addOnSuccessListener { res ->
                for (datae in res) {
                    val data = datae.data
                    val idReferencia = data?.get("id") as? String ?: ""
                    if (idReferencia == idRefCreado) {
                        val hashMap = hashMapOf<String, Any>(
                            "log" to binding.longituduser.text.toString(),
                            "lat" to binding.latitudUSer.text.toString(),
                            "direccion" to binding.direccionCasaED.text.toString(),
                            "referencia" to binding.referenciaED.text.toString()
                        )
                        db.document(idRefCreado).set(hashMap, SetOptions.merge())
                            .addOnSuccessListener {
                                Toast.makeText(
                                    this,
                                    "cambios realizados correctamente",
                                    Toast.LENGTH_SHORT
                                ).show()

                                obtenerUbicaciones(firebaseAuth.uid.toString())

                                // Limpiar campos y ocultar vistas
                                binding.nombreColeccionED.setText("")
                                binding.direccionCasaED.setText("")
                                binding.referenciaED.setText("")
                                binding.linealForm.isVisible = false
                                binding.editar.isVisible = false
                                binding.eliminar.isVisible = false
                            }.addOnFailureListener { e->
                                Log.e("error_actualizar","error al actulizar los datos")
                            }
                    } else {
                        Log.d("encontrado", "no se enconotr uina igual")

                    }
                }
            }
        } else {
            val hashMap = hashMapOf<String, Any>(
                "nombre" to binding.nombreColeccionED.text.toString(),
                "log" to binding.longituduser.text.toString(),
                "lat" to binding.latitudUSer.text.toString(),
                "direccion" to binding.direccionCasaED.text.toString(),
                "referencia" to binding.referenciaED.text.toString()
            )

            db.add(hashMap)
                .addOnSuccessListener { documentReference ->
                    // Ahora actualizamos el documento con su ID generado
                    documentReference.update("id", documentReference.id)
                        .addOnSuccessListener {
                            Toast.makeText(
                                this,
                                "Ubicación agregada correctamente con ID: ${documentReference.id}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        .addOnFailureListener { e ->
                            Toast.makeText(
                                this,
                                "Error al actualizar el ID: ${e.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    obtenerUbicaciones(firebaseAuth.uid.toString())

                    // Limpiar campos y ocultar vistas
                    binding.nombreColeccionED.setText("")
                    binding.direccionCasaED.setText("")
                    binding.referenciaED.setText("")
                    binding.linealForm.isVisible = false
                    binding.editar.isVisible = false
                    binding.eliminar.isVisible = false
                }
                .addOnFailureListener { e ->
                    Toast.makeText(
                        this,
                        "Error al subir la ubicación: ${e.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
        }


    }


    private fun getLocation(completado: (Boolean) -> Unit) {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
            return
        }

        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->

                if (location != null) {
                    completado(true)
                    val latitude = location.latitude
                    val longitude = location.longitude
                    binding.direccion.setText("$latitude,$longitude")
                    binding.latitudUSer.text = latitude.toString()
                    binding.longituduser.text = longitude.toString()

                } else {
                    completado(false)
                    Toast.makeText(
                        this,
                        "Active su ubicacion en el dispositivo",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
            .addOnFailureListener { e ->
                completado(false)
                Toast.makeText(
                    this,
                    "Error al obtener la ubicación: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLocation() {}
            } else {
                Toast.makeText(this, "Permiso de ubicación denegado.", Toast.LENGTH_SHORT).show()
            }
        }
    }


}