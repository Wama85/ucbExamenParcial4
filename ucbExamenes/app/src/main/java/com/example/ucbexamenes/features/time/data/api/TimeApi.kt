package com.example.ucbexamenes.features.time.data.api

import com.example.ucbexamenes.features.time.data.dto.ServerTimeResponse
import retrofit2.http.GET

interface TimeApi {

    @GET("timezone/America/La_Paz")
    suspend fun getServerTime(): ServerTimeResponse
}
