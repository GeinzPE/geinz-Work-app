package com.geinzz.geinzwork.publicaciones_trabajadores

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.geinzwork.constantesGeneral.Variables
import com.geinzz.geinzwork.R
import com.geinzz.geinzwork.databinding.ActivityAgregarRedesBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class agregar_redes : AppCompatActivity() {
    private lateinit var binding: ActivityAgregarRedesBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgregarRedesBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        firebaseAuth = FirebaseAuth.getInstance()
        binding.Enviar.setOnClickListener {
            agregarRedes(firebaseAuth.uid.toString())
        }
        binding.limpiarFB.setOnClickListener {
            binding.fbEd.setText("")
        }
        binding.limpiarIG.setOnClickListener {
            binding.igED.setText("")
        }
        binding.limpiarTK.setOnClickListener {
            binding.tkED.setText("")
        }
        obtnerDatos(firebaseAuth.uid.toString())
    }

    private fun obtnerDatos(id: String) {
        val db = FirebaseFirestore.getInstance().collection(Variables.trabajadores_usuariosDB)
            .document(Variables.trabajadoresDB).collection(Variables.trabajadoresDB).document(id)
        db.get().addOnSuccessListener { res ->
            if (res.exists()) {
                val data = res.data
                val ig = data?.get(Variables.IG) as? String ?: ""
                val fb = data?.get(Variables.FB) as? String ?: ""
                val tk = data?.get(Variables.TK) as? String ?: ""
                binding.igED.setText(ig)
                binding.fbEd.setText(fb)
                binding.tkED.setText(tk)
            } else {
                Log.d(TAG, "El documento no existe")
            }
        }.addOnFailureListener { e ->
            Log.e(TAG, "Error al obtener datos: ${e.message}", e)
        }
    }


    private fun agregarRedes(id: String) {
        val db = FirebaseFirestore.getInstance().collection(Variables.trabajadores_usuariosDB)
            .document(Variables.trabajadoresDB).collection(Variables.trabajadoresDB).document(id)
        val hasmap = hashMapOf<String, Any>(
            Variables.IG to binding.igED.text.toString(),
            Variables.FB to binding.fbEd.text.toString(),
            Variables.TK to binding.tkED.text.toString()
        )
        db.set(hasmap, SetOptions.merge()).addOnSuccessListener {
            Toast.makeText(
                this,
                "Redes agregadas o editadas correctamente",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}