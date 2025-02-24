package com.example.geinzwork.adapterViewholder

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.geinzwork.constantesGeneral.Variables
import com.example.geinzwork.dataclass.dataclass_adapter_promociones
import com.example.geinzwork.oferta_principales_geinz
import com.geinzz.geinzwork.databinding.ItemPromocionesGeinzBinding

class adapter_promociones_principales_geinz(private val lista_item: MutableList<dataclass_adapter_promociones>) :
    RecyclerView.Adapter<adapter_promociones_principales_geinz.viewHolder>() {
    init {
        lista_item.shuffle()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val binding =
            ItemPromocionesGeinzBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(binding)
    }

    override fun getItemCount(): Int = if (lista_item.size >= 5) 5 else lista_item.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item = lista_item[position]
        holder.render(item)
    }

    inner class viewHolder(private val binding: ItemPromocionesGeinzBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun render(item: dataclass_adapter_promociones) {
            val img = binding.imgPromo
            val titulo = binding.tituloPromo
            val texto = binding.textoPromo
            titulo.text = item.titulo_promo
            texto.text = item.texto_promo

            try {
                Glide.with(itemView.context)
                    .load(item.img)
                    .into(img)
            } catch (e: Exception) {
                println("error al setear la img")
            }
            img.setOnClickListener { listaner(item.id.toString(), itemView.context) }
        }

    }

    private fun listaner(id: String, context: Context) {
        var vista = Intent(context, oferta_principales_geinz::class.java).apply {
            putExtra(Variables.idPublicidad, id)
        }
        context.startActivity(vista)
    }

}