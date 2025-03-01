package com.geinzz.geinzwork.adapterViewholder

import ImageDialogFragmentURL
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geinzz.geinzwork.constantesGeneral.constantestextos_general
import com.geinzz.geinzwork.databinding.ItemTrabajosRalizadosBinding
import com.geinzz.geinzwork.dataclass.dataclas_trabajos_ralizados

class adapterTrabajo_realizados(private val listaTrabajos_realizados: MutableList<dataclas_trabajos_ralizados>) :
    RecyclerView.Adapter<adapterTrabajo_realizados.viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val binding =
            ItemTrabajosRalizadosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listaTrabajos_realizados.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item = listaTrabajos_realizados[position]
        holder.render(item)
    }

    class viewHolder(private val binding: ItemTrabajosRalizadosBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun render(item: dataclas_trabajos_ralizados) {
            val img = binding.imagenTrabajo
            val titulo = binding.titulo
            val contenido = binding.contenido
            val fecha = binding.fecha
            val hora = binding.hora

            binding.imagenTrabajo.setOnLongClickListener {
                item.img?.let { uri ->
                    val dialogFragment = ImageDialogFragmentURL.newInstance(uri)
                    dialogFragment.show(
                        (itemView.context as AppCompatActivity).supportFragmentManager,
                        "image_dialog"
                    )
                    true
                } ?: run {
                    Toast.makeText(itemView.context, "No URI available", Toast.LENGTH_SHORT).show()
                    false
                }
            }
            constantestextos_general.extender_acortar_texto(
                binding.titulo,
                binding.tvReadMoreTitulo
            )
            constantestextos_general.extender_acortar_texto(
                binding.contenido,
                binding.tvReadMoreContenido
            )
            try {
                Glide.with(itemView.context)
                    .load(item.img)
                    .into(img)
            } catch (e: Exception) {
                println("problema al setear la img $e")
            }
            titulo.text = item.titulo
            contenido.text = item.contenido
            fecha.text = item.fecha
            hora.text = item.hora
        }

    }
}