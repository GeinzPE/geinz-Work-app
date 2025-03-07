package com.geinzz.geinzwork.adapterViewholder

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.geinzwork.constantesGeneral.Variables
import com.example.geinzwork.constantesGeneral.constatnes_carga_imagenes_general
import com.geinzz.geinzwork.R
import com.geinzz.geinzwork.databinding.ItemProductosTiendasBinding
import com.geinzz.geinzwork.dataclass.dataclas_trabajos_ralizados
import com.geinzz.geinzwork.publicaciones_trabajadores.editar_publicaciones

class publicaciones_ralizadas(private val listaTrabajos_realizados: MutableList<dataclas_trabajos_ralizados>) :
    RecyclerView.Adapter<publicaciones_ralizadas.viewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val binding =
            ItemProductosTiendasBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listaTrabajos_realizados.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item = listaTrabajos_realizados[position]
        holder.render(item)
    }

    class viewHolder(private val binding: ItemProductosTiendasBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun render(item: dataclas_trabajos_ralizados) {
            binding.precioProducto.isVisible = false
            binding.tituloProducto.text = item.titulo
            binding.descripcionProducto.text = item.contenido
            binding.pen.isVisible = false

            val placeholderperfil = ContextCompat.getDrawable(itemView.context, R.drawable.cargando_img_geinz_500)
            constatnes_carga_imagenes_general.changer_img(
                binding.progressCargaImagen,
                itemView.context,
                item.img.toString(),
               null,
                binding.imgProducto,
                "portada", placeholderperfil
            )

            binding.Editar.setOnClickListener {
                var intent = Intent(itemView.context, editar_publicaciones::class.java).apply {
                    putExtra(Variables.titulo,item.titulo)
                    putExtra(Variables.descripcion,item.contenido)
                    putExtra(Variables.img,item.img)
                    putExtra(Variables.id,item.id_publicacion)
                }
                itemView.context.startActivity(intent)
            }
        }

    }
}