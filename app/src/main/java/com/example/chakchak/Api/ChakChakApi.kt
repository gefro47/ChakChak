package com.example.chakchak.Api

import android.net.Uri
import android.util.Log
import com.example.chakchak.model.RandomJokes
import com.example.chakchak.utilits.BASE_URL
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

class ChakChakApi() {

    fun GetJokes(number: Int): RandomJokes?{
        val builder = Uri.Builder()
        builder.scheme("http")
            .encodedAuthority("$BASE_URL")
            .appendPath("jokes")
            .appendPath("random")
            .appendPath("$number")
        val url = builder.build().toString()

        Log.d("url", "$url")

        val request = Request.Builder()
            .url(url)
            .build()

        val client = OkHttpClient()
        client.newCall(request).execute().use { response ->
            response.use {
                return try {
                    Gson().fromJson(response.body?.string(), RandomJokes::class.java)
                } catch (e: Exception) {
                    null
                }
            }
        }
    }

}