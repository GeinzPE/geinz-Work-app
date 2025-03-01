package com.geinzz.geinzwork.constantesGeneral

import android.annotation.SuppressLint
import android.content.Context
import android.widget.LinearLayout

import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.geinzwork.constantesGeneral.Variables
import com.geinzz.geinzwork.dataclass.dataclas_trabajos_ralizados
import com.google.android.material.appbar.AppBarLayout
import com.google.firebase.firestore.FirebaseFirestore

object constantes_publicaciones_general_user_tiendas {

    @SuppressLint("SuspiciousIndentation")
    fun obtenerPublicaciones(
        plan: String,
        id: String,
        lista: MutableList<dataclas_trabajos_ralizados>,
        recicleTrabajosRealizados: RecyclerView,
        context: Context,
        adapter: RecyclerView.Adapter<*>,
        linealappLayout: AppBarLayout,
        lineal_no_cuenta: LinearLayout, linealTrabajosTralizados: LinearLayout

    ) {
        if (plan ==  Variables.plaA) {
            lineal_no_cuenta.isVisible = false
        } else if (plan == Variables.planB || plan == Variables.PlanC) {
            val db = FirebaseFirestore.getInstance().collection(Variables.trabajadores_usuariosDB)
                .document(Variables.trabajadoresDB).collection(Variables.trabajadoresDB).document(id)
                .collection(Variables.trabajos_realizados)

            lineal_no_cuenta.isVisible = false
            lista.clear()
            db.get().addOnSuccessListener { res ->
                for (datos in res) {
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
                    lineal_no_cuenta.isVisible = false
                    linealTrabajosTralizados.isVisible = true

                }
                if (lista.isEmpty()) {
                    lineal_no_cuenta.isVisible = true
                    linealTrabajosTralizados.isVisible = false

                } else {
                    linealTrabajosTralizados.isVisible = true
                    lineal_no_cuenta.isVisible = false
                    inicializarRecicle(recicleTrabajosRealizados, adapter, context)
                }

            }
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