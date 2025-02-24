package com.geinzz.geinzwork.adapterViewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geinzz.geinzwork.databinding.ItemTrabajosMostradosBinding
import com.geinzz.geinzwork.dataclass.dataClassTrabajosMostrados

class adapterTrabajos(
    private val lista: MutableList<dataClassTrabajosMostrados>,
    private val vermas: (dataClassTrabajosMostrados) -> Unit
) :
    RecyclerView.Adapter<adapterTrabajos.viewHoldeTrabajos>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHoldeTrabajos {
        val binding =
            ItemTrabajosMostradosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHoldeTrabajos(binding)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: viewHoldeTrabajos, position: Int) {
        val item = lista[position]
        holder.render(item, vermas)
    }

    inner class viewHoldeTrabajos(private val binding: ItemTrabajosMostradosBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val img = binding.imgTrabajo
        val nombre = binding.titulo
        val tipoT = binding.tiposT
        val layaout = binding.LinealVermas

        fun render(
            dataClassTrabajosMostrados: dataClassTrabajosMostrados,
            vermas: (dataClassTrabajosMostrados) -> Unit
        ) {
            layaout.setOnClickListener {
                vermas(dataClassTrabajosMostrados)
            }
            tipoT.text = dataClassTrabajosMostrados.tipoT
            try {
                Glide.with(itemView.context)
                    .load(dataClassTrabajosMostrados.imgResId)
                    .into(img)
            } catch (e: Exception) {
                println("error al setear la img")
            }
            nombre.text = dataClassTrabajosMostrados.categorias
        }
    }

}