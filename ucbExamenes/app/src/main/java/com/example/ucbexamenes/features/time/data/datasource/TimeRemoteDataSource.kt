package com.example.ucbexamenes.features.time.data.datasource

import com.example.ucbexamenes.features.time.data.api.RetrofitInstance
import java.net.SocketTimeoutException

class TimeRemoteDataSource {

    suspend fun fetchTimeFromServer(): String {
        return try {
            val response = RetrofitInstance.api.getServerTime()

            // dateTime = "2025-11-29T08:32:15.1234567"
            val full = response.dateTime

            full.substringAfter("T").substring(0, 8)
        } catch (e: SocketTimeoutException) {
            // Si hay timeout, lanzar excepción para que el repository lo maneje
            throw Exception("Tiempo de espera agotado. Por favor verifica tu conexión.")
        } catch (e: Exception) {
            // Cualquier otro error
            throw Exception("Error al obtener la hora del servidor: ${e.message}")
        }
    }
}