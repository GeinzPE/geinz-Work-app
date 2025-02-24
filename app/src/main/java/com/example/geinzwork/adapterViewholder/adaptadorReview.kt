package com.geinzz.geinzwork.adapterViewholder

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geinzz.geinzwork.R
import com.geinzz.geinzwork.constantesGeneral.constantesCarrito
import com.geinzz.geinzwork.constantesGeneral.constantestextos_general
import com.geinzz.geinzwork.databinding.ItemReviewBinding
import com.geinzz.geinzwork.dataclass.daclassReview

class adaptadorReview(
    private val listaReview: MutableList<daclassReview>,

    ) : RecyclerView.Adapter<adaptadorReview.viewHolderReview>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolderReview {
        val binding = ItemReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolderReview(binding)

    }

    override fun getItemCount(): Int {
        return listaReview.size
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: viewHolderReview, position: Int) {
        val item = listaReview[position]
        holder.render(item)
    }

    inner class viewHolderReview(private val binding: ItemReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val review = binding.review
        val nombrevw = binding.nombre
        val imgperfil = binding.imgPerfilUser
        val imgpeStart = binding.cantidadStart
        val hora = binding.hora
        val fecha = binding.fecha

        fun render(daclassReview: daclassReview) {
            review.text = daclassReview.review
            fecha.text = daclassReview.fecha
            hora.text = daclassReview.hora

            setearStarts(daclassReview)
            constantesCarrito.setearDatosUsuarioImgNombre(idUSer = daclassReview.idUsuarioReview.toString()) { nombre, img, apellido ->
                binding.nombre.text = "$nombre $apellido"
                println("id del user ${daclassReview.idUsuarioReview.toString()}")
                try {
                    Glide.with(itemView.context)
                        .load(img)
                        .into(binding.imgPerfilUser)
                } catch (e: Exception) {
                    println("error al setear la img")
                }
            }

            constantestextos_general.textoPrimarioBold(daclassReview, binding.review)

            constantestextos_general.textoPrimarioBold2(daclassReview, binding.tipoTrabajo)

            if (daclassReview.editado == true) {
                binding.editado.isVisible = true
            } else {
                binding.editado.isVisible = false
            }

        }


        fun setearStarts(daclassReview: daclassReview) {
            try {
                val drawableId = when (daclassReview.cantidaStarts) {
                    "1" -> R.drawable.start_one
                    "2" -> R.drawable.start_two
                    "3" -> R.drawable.start_tree
                    "4" -> R.drawable.start_four
                    "5" -> R.drawable.start_five
                    else -> R.drawable.start_one // Puedes tener un recurso predeterminado para casos inválidos
                }

                Glide.with(itemView.context)
                    .load(drawableId)
                    .into(imgpeStart)
            } catch (e: Exception) {
                println(e)
            }
        }

    }
}