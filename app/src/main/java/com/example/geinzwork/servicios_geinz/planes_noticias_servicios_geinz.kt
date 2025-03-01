package com.geinzz.geinzwork.servicios_geinz

import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.geinzwork.NotificacionRS
import com.example.geinzwork.constantesGeneral.Variables
import com.example.geinzwork.constantesGeneral.obtenertokenIdAdmin
import com.geinzz.geinzwork.R
import com.geinzz.geinzwork.constantesGeneral.constantes
import com.geinzz.geinzwork.constantesGeneral.constantesCarrito
import com.geinzz.geinzwork.constantesGeneral.constantesPublicidad
import com.geinzz.geinzwork.databinding.ActivityPlanesNoticiasServiciosGeinzBinding
import com.geinzz.geinzwork.databinding.BottomSheetAdquirPlanesNoticiasBinding
import com.geinzz.geinzwork.planes
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class planes_noticias_servicios_geinz : AppCompatActivity() {
    private lateinit var binding: ActivityPlanesNoticiasServiciosGeinzBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var dialog: BottomSheetDialog

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlanesNoticiasServiciosGeinzBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val intentRenovacion = intent.getStringExtra(Variables.renovacion).toString()
        dialog = BottomSheetDialog(this)
        firebaseAuth = FirebaseAuth.getInstance()
        val caracteristicasbasica = listOf(
            getString(R.string.plan_basico_presencia),
            getString(R.string.plan_basico_difusion),
            getString(R.string.plan_basico_control),
            getString(R.string.plan_basico_asesoria),
            getString(R.string.plan_basico_enlace),
            getString(R.string.plan_basico_notificaciones)
        )
        val caracteristicaAvanzado = listOf(
            getString(R.string.plan_premium_exposicion),
            getString(R.string.plan_premium_estadisticas),
            getString(R.string.plan_premium_alcance),
            getString(R.string.plan_premium_control),
            getString(R.string.plan_premium_asesoria),
            getString(R.string.plan_premium_enlace),
            getString(R.string.plan_premium_notificaciones),

            )

        planesBasico(dialog, caracteristicasbasica, intentRenovacion)
        plan_avanzado(dialog, caracteristicaAvanzado, intentRenovacion)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun planesBasico(
        dialog: BottomSheetDialog,
        caracteristicas: List<String>,
        intentRenovacion: String
    ) {
        InfladoPlanes(caracteristicas, binding.planBasico.linealCaracteristicasLayout)
        binding.planBasico.precio.text = getString(R.string.precio_plan_basico)
        binding.planBasico.planNombre.text = getString(R.string.plan_nombre_B)
        binding.planBasico.verMas.setOnClickListener {
            enviarFormularioGeinz(
                dialog,
                getString(R.string.plan_basico_descripcion),
                getString(R.string.precio_plan_basico),
                getString(R.string.tipo_servicio_plan_basico), intentRenovacion
            )
            dialog.show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun plan_avanzado(
        dialog: BottomSheetDialog,
        caracteristicas: List<String>,
        intentRenovacion: String
    ) {
        InfladoPlanes(caracteristicas, binding.planAvanzado.linealCaracteristicasLayout)
        binding.planAvanzado.precio.text = getString(R.string.precio_plan_avanzado)
        binding.planAvanzado.planNombre.text = getString(R.string.plan_nombre_A)
        binding.planAvanzado.verMas.setOnClickListener {
            enviarFormularioGeinz(
                dialog,
                getString(R.string.plan_avanzado_descripcion),
                getString(R.string.precio_plan_avanzado),
                getString(R.string.tipo_servicio_plan_avanzado), intentRenovacion
            )
            dialog.show()
        }
    }


    private fun InfladoPlanes(caracteristicas: List<String>, layoutParams: LinearLayout) {
        val layout = layoutParams
        layout.removeAllViews()
        for (caracteristicastxt in caracteristicas) {
            val textView = TextView(this)
            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(0, 8, 0, 8)
            textView.layoutParams = layoutParams

            textView.text = caracteristicastxt
            textView.textSize = 15f
            textView.setTypeface(null, Typeface.BOLD)
            textView.setTextAppearance(R.style.TextoModoOScuroColor)
            layout.addView(textView)
        }
    }

    fun verificarCampos(bindingBottomShett: BottomSheetAdquirPlanesNoticiasBinding): Boolean {
        val nombre = bindingBottomShett.nombreED.text
        val apellido = bindingBottomShett.apellidosED.text
        val dni = bindingBottomShett.dniED.text
        val telefono = bindingBottomShett.telefonoed.text
        var isValid = true

        if (nombre.isNullOrBlank()) {
            bindingBottomShett.nombreED.error = getString(R.string.campo_nombre)
            isValid = false
        }
        if (apellido.isNullOrBlank()) {
            bindingBottomShett.apellidosED.error = getString(R.string.campo_apellido)
            isValid = false
        }
        if (dni.isNullOrBlank()) {
            bindingBottomShett.dniED.error = getString(R.string.campo_dni)
            isValid = false
        }
        if (telefono.isNullOrBlank()) {
            bindingBottomShett.telefonoed.error = getString(R.string.campo_telefono)
            isValid = false
        }
        return isValid
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun enviarFormularioGeinz(
        dialog: BottomSheetDialog,
        descripcion: String,
        total: String,
        tipo_servicio: String,
        renovacion: String
    ) {

        val bindingBottomSheet =
            BottomSheetAdquirPlanesNoticiasBinding.inflate(LayoutInflater.from(this))
        BottomSheetDialog(this)

        if (firebaseAuth.currentUser == null) {
            constantesPublicidad.CreacionCuentaBottom_shett(this, dialog)
            dialog.show()
            return
        }

        // Establece la descripción, tipo de servicio y total
        bindingBottomSheet.descripcion.text = descripcion
        bindingBottomSheet.tipoServicio.text = tipo_servicio
        bindingBottomSheet.Total.text = total

        // Obtén y establece los datos del usuario
        constantesCarrito.setearDatosUsuario { nombre, numero, localida, apellido ->
            bindingBottomSheet.nombreED.setText(nombre)
            bindingBottomSheet.apellidosED.setText(apellido)
            bindingBottomSheet.telefonoed.setText(numero)
        }
        constantesCarrito.obtnerfechaHora(bindingBottomSheet.hora, bindingBottomSheet.fecha)


        // Configuración del botón de cerrar y del botón de enviar
        bindingBottomSheet.cerrar.setOnClickListener {
            dialog.dismiss()
        }

        bindingBottomSheet.btnApply.setOnClickListener {
            val uid = firebaseAuth.uid.toString() // Guarda el UID para evitar llamadas redundantes
            val db = FirebaseFirestore.getInstance()
                .collection(Variables.solicitudes_serviciosDB)
                .document(Variables.publicidadNoticiasDB)
                .collection(Variables.activos)
                .document(uid)

            db.get().addOnSuccessListener { res ->
                // Verifica si ya existe una solicitud activa
                if (res.exists() && renovacion != "r") {
                    Toast.makeText(
                        this,
                        "Ya tiene un servicio de Noticia activo",
                        Toast.LENGTH_SHORT
                    ).show()
                    dialog.dismiss()
                    return@addOnSuccessListener
                }

                // Valida que todos los campos requeridos estén completos
                if (!verificarCampos(bindingBottomSheet)) {
                    return@addOnSuccessListener
                }

                // Obtener token del trabajador y proceder a enviar la solicitud
                constantes.obtenerToken_trabajador(uid) { tokenUser, nombre, apellido ->
                    val dbGeneral = FirebaseFirestore.getInstance()
                        .collection(Variables.solicitudes_serviciosDB)
                        .document(Variables.publicidadNoticiasDB)

                    val referencia = if (renovacion == "r") {
                        dbGeneral.collection(Variables.renovarDB)
                    } else {
                        dbGeneral.collection(Variables.pendientesDB)
                    }

                    val tituloNotificacion = if (renovacion == "r") {
                        getString(R.string.titulo_notificacion_noticias_renovacion)
                    } else {
                        getString(R.string.titulo_notificacion_noticias)
                    }

                    val mensajeNotificacion = if (renovacion == "r") {
                        getString(
                            R.string.mensaje_notificacion_anuncio_renovacion,
                            bindingBottomSheet.tipoServicio.text.toString(),
                            bindingBottomSheet.Total.text.toString()
                        )
                    } else {
                        getString(
                            R.string.mnjs_notificacion,
                            bindingBottomSheet.tipoServicio.text.toString(),
                            bindingBottomSheet.Total.text.toString()
                        )
                    }

                    // Crear el HashMap con los datos del formulario
                    val solicitudData = hashMapOf<String, Any>(
                        Variables.nombre to bindingBottomSheet.nombreED.text.toString(),
                        Variables.apellido to bindingBottomSheet.apellidosED.text.toString(),
                        Variables.DNI to bindingBottomSheet.dniED.text.toString(),
                        Variables.telefono to bindingBottomSheet.telefonoed.text.toString(),
                        Variables.total to bindingBottomSheet.Total.text.toString(),
                        Variables.fecha to bindingBottomSheet.fecha.text.toString(),
                        Variables.hora to bindingBottomSheet.hora.text.toString(),
                        Variables.tipo_servicio to bindingBottomSheet.tipoServicio.text.toString(),
                        Variables.id_usuario to uid,
                        Variables.token to tokenUser
                    )

                    // Agregar la solicitud a la base de datos
                    referencia.add(solicitudData).addOnSuccessListener { documentReference ->
                        val documentId = documentReference.id
                        referencia.document(documentId).update(Variables.idSolicitud, documentId)
                            .addOnSuccessListener {
                                enviarNoticacion(
                                    "idAdmin",
                                    "hola",
                                    tituloNotificacion,
                                    mensajeNotificacion
                                )
                                Toast.makeText(
                                    this,
                                    "Solicitud enviada correctamente",
                                    Toast.LENGTH_SHORT
                                ).show()
                                dialog.dismiss()
                            }.addOnFailureListener { e ->
                                manejarError(e, "Error al actualizar la solicitud.")
                            }
                    }.addOnFailureListener { e ->
                        manejarError(e, "Error al enviar el formulario.")
                    }
                }
            }.addOnFailureListener { e ->
                manejarError(e, "Error al verificar la solicitud activa.")
            }
        }


        dialog.setContentView(bindingBottomSheet.root)
        dialog.show()
    }

    private fun manejarError(e: Exception, mensaje: String) {
        Log.e("FormularioError", mensaje, e)
    }

    fun enviarNoticacion(enviado1: String, vista: String, Titulo: String, texto: String) {
        GlobalScope.launch {
            val notificacionRS = NotificacionRS()
            obtenertokenIdAdmin.obtenertokenAdmin { token, id ->
                GlobalScope.launch {
                    notificacionRS.sendNotification_con_parametros(
                        enviado1,
                        id,
                        vista,
                        this@planes_noticias_servicios_geinz,
                        token,
                        Titulo,
                        texto
                    )
                }
            }
        }
    }
}