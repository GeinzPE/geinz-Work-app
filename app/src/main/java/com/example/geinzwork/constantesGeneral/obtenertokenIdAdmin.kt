package com.example.geinzwork.constantesGeneral

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

object obtenertokenIdAdmin {
    fun obtenertokenAdmin(callbackk: (String, String) -> Unit) {
        val db = FirebaseFirestore.getInstance().collection(Variables.trabajadores_usuariosDB)
            .document(Variables.adminDB).collection(Variables.adminDB)
        db.get().addOnSuccessListener { res ->
            for (dat in res) {
                val datos = dat.data
                val token = datos[Variables.token] as? String ?: ""
                val id = datos[Variables.id] as? String ?: ""
                callbackk(token, id)
            }

        }.addOnFailureListener { e ->
            callbackk("", "")
            Log.e("error_token", "error al obtenr los datos del usuario")
        }
    }
}