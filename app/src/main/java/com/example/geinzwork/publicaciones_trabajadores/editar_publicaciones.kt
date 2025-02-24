package com.geinzz.geinzwork.publicaciones_trabajadores

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.geinzwork.constantesGeneral.Variables
import com.geinzz.geinzwork.R
import com.geinzz.geinzwork.databinding.ActivityEditarPublicacionesBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class editar_publicaciones : AppCompatActivity() {
    private lateinit var binding: ActivityEditarPublicacionesBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditarPublicacionesBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        firebaseAuth = FirebaseAuth.getInstance()
        val titulo = intent.getStringExtra(Variables.titulo).toString()
        val descripcion = intent.getStringExtra(Variables.descripcion).toString()
        val img = intent.getStringExtra(Variables.img).toString()
        val idPublicacion = intent.getStringExtra(Variables.id).toString()

        binding.tituloPublicacionED.setText(titulo)
        binding.descripcionServiciosED.setText(descripcion)
        try {
            Glide.with(this)
                .load(img)
                .into(binding.imagenTrabajo)
        } catch (e: Exception) {
            println("error al setear la img")
        }
        binding.editar.setOnClickListener {
            editar_info(idPublicacion,
                binding.tituloPublicacionED.text.toString(),
                binding.descripcionServiciosED.text.toString()
            )
        }
        binding.eliminar.setOnClickListener {
            val db = FirebaseFirestore.getInstance().collection(Variables.trabajadores_usuariosDB)
                .document(Variables.trabajadoresDB)
                .collection(Variables.trabajadoresDB)
                .document(firebaseAuth.uid.toString())
                .collection(Variables.trabajos_realizados)
                .document(idPublicacion)
            db.delete().addOnSuccessListener {
                Toast.makeText(
                    this,
                    "Publicacion eliminada correctamente",
                    Toast.LENGTH_SHORT
                ).show()
            }
                .addOnFailureListener {
                    Toast.makeText(
                        this,
                        "Error al eliminar la publicacion",
                        Toast.LENGTH_SHORT
                    ).show()
                }
        }
    }

    private fun editar_info(idPublicacion:String,nuevoTitulo: String, nuevaDescripcion: String) {

        val db = FirebaseFirestore.getInstance().collection(Variables.trabajadores_usuariosDB)
            .document(Variables.trabajadoresDB)
            .collection(Variables.trabajadoresDB)
            .document(firebaseAuth.uid.toString())
            .collection(Variables.trabajos_realizados)
            .document(idPublicacion)
        val updates = hashMapOf<String, Any>(
            Variables.titulo to nuevoTitulo,
            Variables.descripcion to nuevaDescripcion
        )
        db.update(updates)
            .addOnSuccessListener {
                Toast.makeText(this, "Campos actualizados correctamente", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(
                    this,
                    "Error al actualizar los campos: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

}