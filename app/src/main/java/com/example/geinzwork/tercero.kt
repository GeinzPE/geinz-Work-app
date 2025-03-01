package com.geinzz.geinzwork

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.geinzz.geinzwork.databinding.ActivityTerceroBinding
import com.google.firebase.auth.FirebaseAuth

class tercero : AppCompatActivity() {
    private lateinit var binding:ActivityTerceroBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTerceroBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        firebaseAuth=FirebaseAuth.getInstance()
        binding.Siguiente.setOnClickListener {

            startActivity(Intent(this, cuarto::class.java))
            finish()
        }
    }
}