package com.example.geinzwork.constantesGeneral

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.progressindicator.CircularProgressIndicator
import de.hdodenhof.circleimageview.CircleImageView
import com.bumptech.glide.request.target.Target // Importa Target de Glide

object constatnes_carga_imagenes_general {
    fun changer_img(
        progressBar: CircularProgressIndicator,
        context: Context,
        url: String,
        circle_img: CircleImageView? = null,
        shapeableImageView: ShapeableImageView? = null,
        type: String,
        placeholder: Drawable? = null // Drawable opcional como placeholder
    ) {
        try {
            progressBar.visibility = View.VISIBLE

            val glideRequest = Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)

            placeholder?.let { glideRequest.placeholder(it) } // Establece el placeholder si no es nulo

            glideRequest.listener(object : RequestListener<Drawable> {
                override fun onResourceReady(
                    resource: Drawable,
                    model: Any,
                    target: Target<Drawable>?,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar.visibility = View.GONE
                    return false
                }


                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar.visibility = View.GONE
                    return false
                }
            })
                .apply {
                    when (type) {
                        "perfil" -> circle_img?.let { into(it) }
                        "portada" -> shapeableImageView?.let { into(it) }
                    }
                }
        } catch (e: Exception) {
            println("problema al setear la img $e")
        }
    }
}