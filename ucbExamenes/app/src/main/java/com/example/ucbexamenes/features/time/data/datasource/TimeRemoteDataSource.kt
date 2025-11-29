package com.example.ucbexamenes.features.time.data.datasource

import com.example.ucbexamenes.features.time.data.api.RetrofitInstance

class TimeRemoteDataSource {

    suspend fun fetchTimeFromServer(): String {
        val response = RetrofitInstance.api.getServerTime()

        val full = response.datetime
        return full.substringAfter("T").substring(0, 8)
    }
}
