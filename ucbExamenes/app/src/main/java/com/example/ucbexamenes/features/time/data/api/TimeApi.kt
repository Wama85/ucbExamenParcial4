package com.example.ucbexamenes.features.time.data.api

import com.example.ucbexamenes.features.time.data.dto.ServerTimeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TimeApi {

    @GET("current/zone")
    suspend fun getServerTime(
        @Query("timeZone") zone: String = "America/La_Paz"
    ): ServerTimeResponse
}
