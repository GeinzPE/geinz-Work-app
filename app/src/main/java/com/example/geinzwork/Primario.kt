package com.geinzz.geinzwork

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.geinzz.geinzwork.databinding.ActivityPrimarioBinding
import com.google.firebase.auth.FirebaseAuth

class Primario : AppCompatActivity() {

    private lateinit var binding: ActivityPrimarioBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        val slash=installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityPrimarioBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        firebaseAuth = FirebaseAuth.getInstance()
        slash.setKeepOnScreenCondition{ true }
        startActivity(Intent(this@Primario, segundaria::class.java))
        finish()
    }

}