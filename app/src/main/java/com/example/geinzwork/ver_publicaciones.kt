package com.geinzz.geinzwork

import android.content.Context
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.geinzwork.constantesGeneral.Variables
import com.geinzz.geinzwork.adapterViewholder.adapterTrabajo_realizados
import com.geinzz.geinzwork.adapterViewholder.publicaciones_ralizadas
import com.geinzz.geinzwork.constantesGeneral.constantes_publicaciones_general_user_tiendas
import com.geinzz.geinzwork.databinding.ActivityVerPublicacionesBinding
import com.geinzz.geinzwork.dataclass.dataclas_trabajos_ralizados
import com.google.android.material.appbar.AppBarLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ver_publicaciones : AppCompatActivity() {
    private lateinit var binding: ActivityVerPublicacionesBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private var listAdapter = mutableListOf<dataclas_trabajos_ralizados>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerPublicacionesBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        firebaseAuth = FirebaseAuth.getInstance()
        val adapter = publicaciones_ralizadas(listAdapter)
        obtenerPublicaciones(
            firebaseAuth.uid.toString(),
            listAdapter,
            binding.recicleViewTrabajos,
            this,
            adapter,
            binding.linealNoCuenta,
        )
        binding.CreaPublicacion.setOnClickListener {
            onBackPressed()
        }


    }

    fun obtenerPublicaciones(
        id: String,
        lista: MutableList<dataclas_trabajos_ralizados>,
        recicleTrabajosRealizados: RecyclerView,
        context: Context,
        adapter: RecyclerView.Adapter<*>,
        lineal_no_cuenta: LinearLayout

    ) {
        val db = FirebaseFirestore.getInstance().collection(Variables.trabajadores_usuariosDB)
            .document(Variables.trabajadoresDB).collection(Variables.trabajadoresDB).document(id)
            .collection(Variables.trabajos_realizados)

        binding.loading.isVisible = true
        lineal_no_cuenta.isVisible = false
        recicleTrabajosRealizados.isVisible = false

        db.get().addOnSuccessListener { result ->
            if (result.isEmpty) {
                // La colección no tiene documentos
                binding.loading.isVisible = false
                lineal_no_cuenta.isVisible = true
            } else {
                // La colección tiene documentos, procesar datos
                for (datos in result) {
                    val data = datos.data
                    val titulo = data?.get(Variables.titulo) as? String?:""
                    val imageUrl = data?.get(Variables.imageUrl) as? String?:""
                    val id = data?.get(Variables.id) as? String?:""
                    val hora = data?.get(Variables.hora) as? String?:""
                    val fecha = data?.get(Variables.fecha) as? String?:""
                    val descripcion = data?.get(Variables.descripcion) as? String?:""
                    val trabajoRealizado =
                        dataclas_trabajos_ralizados(imageUrl, titulo, descripcion, fecha, hora, id)
                    lista.add(trabajoRealizado)
                }
                if (lista.isEmpty()) {
                    binding.loading.isVisible = false
                    lineal_no_cuenta.isVisible = true
                } else {
                    binding.loading.isVisible = false
                    lineal_no_cuenta.isVisible = false
                    recicleTrabajosRealizados.isVisible = true
                    inicializarRecicle(recicleTrabajosRealizados, adapter, context)
                    binding.linealappLayout.isVisible=true
                }
            }
        }.addOnFailureListener {
            binding.loading.isVisible = false
            lineal_no_cuenta.isVisible = true
        }

    }

    private fun inicializarRecicle(
        recycle: RecyclerView,
        adapter: RecyclerView.Adapter<*>,
        context: Context
    ) {
        recycle.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recycle.adapter = adapter
    }

}