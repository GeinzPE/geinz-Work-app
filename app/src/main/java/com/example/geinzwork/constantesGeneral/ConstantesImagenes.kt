package com.geinzz.geinzwork.constantesGeneral

import android.content.ContentResolver
import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import com.bumptech.glide.Glide
import com.geinzz.geinzwork.R
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream

object constantesImagenes {

    fun bitmapToUri(bitmap: Bitmap?,contexto:Context): Uri? {
        val contentResolver = contexto.contentResolver
        bitmap ?: return null
        val bytes = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.WEBP, 100, bytes)
        val path = MediaStore.Images.Media.insertImage(contentResolver, bitmap, "Title", null)
        return Uri.parse(path)
    }

    fun reducesize(drawable: Drawable): Bitmap? {
        val originalBitmap = drawable.toBitmap()
        val compressedBitmap = Bitmap.createScaledBitmap(originalBitmap, 1200, 1200, true)

        val outputStream = ByteArrayOutputStream()
        compressedBitmap.compress(Bitmap.CompressFormat.WEBP, 100, outputStream)
        val imageByte = outputStream.toByteArray()
        val compressedWebPBitmap = BitmapFactory.decodeByteArray(imageByte, 0, imageByte.size)

        Log.d(ContentValues.TAG, "Tamaño de la imagen comprimida en WebP: ${imageByte.size} bytes")

        return compressedWebPBitmap
    }

    fun reortnarur(urlImagen: String): String {
        var urlimg = urlImagen
        return urlimg
    }
    suspend fun resizeAndCompressImage(contentResolver: ContentResolver, imageUri: Uri, maxWidth: Int, maxHeight: Int): ByteArray {
        return withContext(Dispatchers.IO) {
            val bitmap = Picasso.get()
                .load(imageUri)
                .resize(maxWidth, maxHeight)
                .onlyScaleDown() // Sólo reducir el tamaño si la imagen es más grande que los límites especificados
                .get()

            val outputStream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, outputStream) // Comprimir al 80%
            outputStream.toByteArray()
        }
    }
     fun refereciaStorage(rutaimgstorege: String, imagenComprimida: ByteArray, nombreimg: String, contexto: Context) {
        val ref = FirebaseStorage.getInstance().getReference(rutaimgstorege)
        ref.putBytes(imagenComprimida)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    ref.downloadUrl.addOnSuccessListener { res ->
                        val urlimg = res.toString()
                        Toast.makeText(
                            contexto,
                            "cargando $nombreimg",
                            Toast.LENGTH_SHORT
                        ).show()
                        var urlObtenida = reortnarur(urlimg)
                        println("obtenemos la url $urlObtenida")
                    }.addOnFailureListener { e ->
                        Toast.makeText(
                            contexto,
                            "Error al obtener la URL de la imagen: $e",
                            Toast.LENGTH_SHORT
                        ).show()
                        println("Error al obtener la URL de la imagen: $e")
                    }
                } else {
                    Toast.makeText(
                        contexto,
                        "Error al subir la imagen: ${task.exception}",
                        Toast.LENGTH_SHORT
                    ).show()
                    println("Error al subir la imagen: ${task.exception}")
                }
            }
    }

    fun obtenerURLDescarga(contexto: Context,yapeqr: ImageView, storageReference: String) {
        val storageReferences=FirebaseStorage.getInstance().getReference(storageReference)
        storageReferences.downloadUrl
            .addOnSuccessListener { uri ->
                val downloadUrl = uri.toString()
                try {
                    Glide.with(contexto)
                        .load(downloadUrl).placeholder(R.drawable.cargando_img_geinz_500).into(yapeqr)
                } catch (e: Exception) {
                    println("error al setear la img")
                }
                yapeqr.setOnClickListener {
                    val imageUrl = downloadUrl
                    val dialogFragment = ImageDialogFragmentURL.newInstance(imageUrl)
                    dialogFragment.show(
                        (contexto as AppCompatActivity).supportFragmentManager,
                        "image_dialog"
                    )
                }
            }
            .addOnFailureListener { exception ->
                println("error al obtener la img ")
            }

    }
}