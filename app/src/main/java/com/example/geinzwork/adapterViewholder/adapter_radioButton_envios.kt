package com.geinzz.geinzwork.adapterViewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geinzz.geinzwork.databinding.RadioBtnDirecionEnviosBinding
import com.geinzz.geinzwork.dataclass.dataclassradiobtn

class adapter_radioButton_envios(
    private val lista: MutableList<dataclassradiobtn>,
    private val onItemClick: (dataclassradiobtn) -> Unit,
) :
    RecyclerView.Adapter<adapter_radioButton_envios.viewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): viewHolder {
        val binding = RadioBtnDirecionEnviosBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: adapter_radioButton_envios.viewHolder, position: Int) {
        val item = lista[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    inner class viewHolder(private val binding: RadioBtnDirecionEnviosBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val btn = binding.docuemnto
        fun render(dataclassradiobtn: dataclassradiobtn) {
            btn.text = dataclassradiobtn.nombreRef
            btn.setOnClickListener {
                onItemClick(dataclassradiobtn)
            }
        }

    }
}