package com.example.ucbexamenes.features.time.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)    // Timeout para conectar
        .readTimeout(30, TimeUnit.SECONDS)       // Timeout para leer respuesta
        .writeTimeout(30, TimeUnit.SECONDS)      // Timeout para escribir
        .retryOnConnectionFailure(true)          // Reintentar si falla
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .build()

    val api: TimeApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://timeapi.io/api/Time/")
            .client(okHttpClient)  // ⭐ Agregar el cliente configurado
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TimeApi::class.java)
    }
}