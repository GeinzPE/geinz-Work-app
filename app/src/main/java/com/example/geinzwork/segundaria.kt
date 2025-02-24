package com.geinzz.geinzwork

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.geinzz.geinzwork.databinding.ActivitySegundariaBinding
import com.google.firebase.auth.FirebaseAuth

class segundaria : AppCompatActivity() {
    private lateinit var binging: ActivitySegundariaBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging = ActivitySegundariaBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binging.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        firebaseAuth = FirebaseAuth.getInstance()

        if (firebaseAuth.currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        }else{

            binging.SguienteCuenta.setOnClickListener {
                startActivity(Intent(this, tercero::class.java))
                finish()
            }
        }

    }

}