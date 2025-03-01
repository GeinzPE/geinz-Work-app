package com.geinzz.geinzwork.adapterViewholder

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.geinzz.geinzwork.R
import com.geinzz.geinzwork.constantesGeneral.constantes
import com.geinzz.geinzwork.constantesGeneral.constantes_servicios
import com.geinzz.geinzwork.databinding.ItemAnunciosBinding
import com.geinzz.geinzwork.databinding.RecicleTrabajosBinding
import com.geinzz.geinzwork.dataclass.dataClassTrabajosd
import com.google.firebase.firestore.FirebaseFirestore
import de.hdodenhof.circleimageview.CircleImageView

class adapterCategorias
    (
    private var lista: MutableList<dataClassTrabajosd>,
    private val vermas: (dataClassTrabajosd) -> Unit,
    private val uidString: String

) : RecyclerView.Adapter<adapterCategorias.viewHolderCategorias>() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolderCategorias {
        val binding =
            RecicleTrabajosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolderCategorias(binding)

    }

    override fun getItemCount(): Int {
        return if (lista.size >= 4) 4 else lista.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: viewHolderCategorias, position: Int) {
        val item = lista[position]
        holder.render(item, vermas,uidString)
    }

    inner class viewHolderCategorias(private val binding: RecicleTrabajosBinding) : RecyclerView.ViewHolder(binding.root) {
        val name = binding.UserName
        val categoria = binding.categoria
        val btnVermas = binding.btnVermas
        val calificacion = binding.CalificaionStart
        val tipoTrabajo = binding.tipoTrabajo
        val imgaenTrabajo = binding.imgTrabajo
        val activo = binding.activo
        val imagenPerfilcicrle = binding.imgPerfilUser
        val nacionalidad = binding.nacionalidad
        val localidad = binding.localidad
        val actividad = binding.acvidad
        val tuCuenta= binding.tuCuenta
        val verificado=binding.verificados

        @RequiresApi(Build.VERSION_CODES.O)
        fun render(dataClassTrabajosd: dataClassTrabajosd, vermas: (dataClassTrabajosd) -> Unit,uidString: String) {
            setearCampos(dataClassTrabajosd, vermas)
            constantes.obtenerFotoPerfil(
                dataClassTrabajosd,
                itemView.context,
                imgaenTrabajo,
                imagenPerfilcicrle
            )
            constantes.setearBanderas(dataClassTrabajosd, itemView.context, nacionalidad)
            Tu_cuentaMostrado(uidString,dataClassTrabajosd)
            constantes_servicios.verificarEstado_vericiacion(binding.verificados,dataClassTrabajosd.id.toString() ){v->}
            constantes.obtenerEstado(actividad,dataClassTrabajosd.id.toString())
        }


        @SuppressLint("SuspiciousIndentation")
        @RequiresApi(Build.VERSION_CODES.O)
        fun setearCampos(
            dataClassTrabajosd: dataClassTrabajosd,
            vermas: (dataClassTrabajosd) -> Unit
        ) {
            name.text = dataClassTrabajosd.nombre
            constantes.setCategoria(dataClassTrabajosd, categoria)
            tipoTrabajo.text = dataClassTrabajosd.tipoT
            calificacion.text = dataClassTrabajosd.start
            localidad.text = dataClassTrabajosd.localidad
            val horaAM = constantes.quitaram(dataClassTrabajosd)
            val horaPM = constantes.quitarpm(dataClassTrabajosd)
            activo.text = "${horaAM} a ${horaPM}"
            btnVermas.setOnClickListener {
                vermas(dataClassTrabajosd)
            }

            if (dataClassTrabajosd.verificados == true) {
                binding.verificados.visibility = View.VISIBLE
            } else {
                binding.verificados.visibility = View.GONE
            }




        }
        fun Tu_cuentaMostrado(uidRegistrado:String,dataClassTrabajosd:dataClassTrabajosd){
            if(uidRegistrado==dataClassTrabajosd.id.toString()){
                tuCuenta.isVisible=true
            }
        }

    }
}