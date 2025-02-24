package com.geinzz.geinzwork

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.geinzwork.constantesGeneral.Variables
import com.geinzz.geinzwork.databinding.ActivityCuentaFreelancerBinding
import com.geinzz.geinzwork.databinding.ActivityGraciasRegistroBinding

class GraciasRegistro : AppCompatActivity() {
    private lateinit var binding: ActivityGraciasRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityGraciasRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nombreUSercap = intent.getStringExtra(Variables.nombreUsuario).toString().toUpperCase()


        binding.userNameCuenta.text = nombreUSercap
        binding.continuarPrincipal.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finishAffinity()
        }

    }
}