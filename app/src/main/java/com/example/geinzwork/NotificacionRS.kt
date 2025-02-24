package com.example.geinzwork

import android.content.Context
import android.util.Log
import com.google.auth.oauth2.GoogleCredentials
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

import okhttp3.Request

class NotificacionRS {
    private val FCM_URL = "https://fcm.googleapis.com/v1/projects/geinzworkapp/messages:send"

    private val client = OkHttpClient()
    suspend fun sendNotification_con_parametros(
        idEnviado1: String,
        v1: String,
        Vista: String,
        context: Context,
        token: String,
        title: String,
        body: String,
    ) {
        val accessToken = getAccessToken(context)
        Log.e("token", "el token es $accessToken")
        Log.d("token_valores","obtenemos los valoes$v1,$token")
        if (accessToken == null) {
            println("Error al obtener el token de acceso")
            Log.e("error_token", "Error al obtener el token de acceso}")
            return
        }

        val jsonPayload = JSONObject().apply {
            put("message", JSONObject().apply {
                put("token", token)
                put("notification", JSONObject().apply {
                    put("title", title)
                    put("body", body)
                })

                put("data", JSONObject().apply {
                    put(idEnviado1, v1)
                    put("click_action", Vista)
                })
                put("android", JSONObject().apply {
                    put("notification", JSONObject().apply {
                        put("click_action", Vista)
                    })
                })

            })
        }
        Log.d("json","obtenemos el $jsonPayload")

        val requestBody = jsonPayload.toString().toRequestBody("application/json".toMediaType())
        val request = Request.Builder()
            .url(FCM_URL)
            .addHeader("Authorization", "Bearer $accessToken")
            .addHeader("Content-Type", "application/json")
            .post(requestBody)
            .build()

        client.newCall(request).execute().use { response ->

            Log.e("Response_codes", "${response.code}")
            Log.e("Response_bodys", "${response.body?.string()}")

        }
    }


    suspend fun getAccessToken(context: Context): String? {
        return withContext(Dispatchers.IO) {
            try {
                val inputStream = context.assets.open("service-account-file.json")
                val googleCredentials = GoogleCredentials.fromStream(inputStream)
                    .createScoped(listOf("https://www.googleapis.com/auth/cloud-platform"))
                googleCredentials.refreshIfExpired()
                googleCredentials.accessToken.tokenValue
            } catch (e: Exception) {
                Log.e("error_token", "erro al obtener el token ${e.printStackTrace()}")

                null
            }
        }
    }
}