package com.geinzz.geinzwork.constantesGeneral

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.view.ViewTreeObserver
import android.widget.TextView
import androidx.core.view.isVisible
import com.geinzz.geinzwork.dataclass.daclassReview

object constantestextos_general {

    fun subrallarTexto(fullText: String, textoAsubrallar: TextView) {
        val fullText = fullText
        val spannableString = SpannableString(fullText)

        val startIndex = fullText.indexOf(fullText)
        val endIndex = startIndex + fullText.length


        spannableString.setSpan(UnderlineSpan(), startIndex, endIndex, 0)
        textoAsubrallar.text = spannableString
    }

    fun textoPrimarioBold(daclassReview: daclassReview, review: TextView) {
        val spannableString =
            SpannableString("Reseña:  ${daclassReview.review}")

        val boldSpan = StyleSpan(Typeface.BOLD)
        val startIndex = 0
        val endIndex = "Reseña".length ?: 0
        spannableString.setSpan(
            boldSpan,
            startIndex,
            endIndex,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        review.text = spannableString
    }

    fun textoPrimarioBold2(daclassReview: daclassReview, review: TextView) {
        if (daclassReview.TipoTrabajo.isNullOrEmpty()) {
            review.isVisible = false
        } else {
            val spannableString =
                SpannableString("Tipo de Trabajo:  ${daclassReview.TipoTrabajo}")

            val boldSpan = StyleSpan(Typeface.BOLD)
            val startIndex = 0
            val endIndex = "Tipo de Trabajo:".length ?: 0
            spannableString.setSpan(
                boldSpan,
                startIndex,
                endIndex,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            review.text = spannableString
        }

    }


    fun extender_acortar_texto(descripcion: TextView, tvReadMore: TextView) {
        descripcion.viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                descripcion.viewTreeObserver.removeOnGlobalLayoutListener(this)
                if (descripcion.lineCount > 2) {
                    tvReadMore.isVisible = true
                    println("el texo es lagor")
                }
            }
        })

        tvReadMore.setOnClickListener {
            if (tvReadMore.text == "Leer más") {
                descripcion.maxLines = Integer.MAX_VALUE
                tvReadMore.text = "Leer menos"
            } else {
                descripcion.maxLines = 3
                tvReadMore.text = "Leer más"
            }
        }
    }
}