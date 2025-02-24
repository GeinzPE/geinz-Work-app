package com.geinzz.geinzwork.adapterViewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geinzz.geinzwork.databinding.ItemCircleCategoriaBinding
import com.geinzz.geinzwork.dataclass.dataClassCategoriasInicio


class adapterTrabajosMostrados(
    private val lista: MutableList<dataClassCategoriasInicio>, private
    val vermas: (dataClassCategoriasInicio) -> Unit
) :
    RecyclerView.Adapter<adapterTrabajosMostrados.viewHoldeTrabajosMostrados>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHoldeTrabajosMostrados {

        val binding = ItemCircleCategoriaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHoldeTrabajosMostrados(binding)

    }

    override fun onBindViewHolder(holder: viewHoldeTrabajosMostrados, position: Int) {
        val item = lista[position]
        holder.render(item, vermas)
    }

    override fun getItemCount(): Int {
        return lista.size
    }


    inner class viewHoldeTrabajosMostrados(private val binding: ItemCircleCategoriaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val img = binding.img
        val click = binding.relativePrincipal
        fun render(
            dataClassCategoriasInicio: dataClassCategoriasInicio,
            vermas: (dataClassCategoriasInicio) -> Unit
        ) {
            try {
                Glide.with(itemView.context)
                    .load(dataClassCategoriasInicio.imgResId)
                    .into(img)

            }catch (e:Exception){
                println("error al setear la img")
            }
            click.setOnClickListener { vermas(dataClassCategoriasInicio) }
        }
    }
}
