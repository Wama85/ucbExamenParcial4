package com.example.ucbexamenes.features.time.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: TimeApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://worldtimeapi.org/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TimeApi::class.java)
    }
}
