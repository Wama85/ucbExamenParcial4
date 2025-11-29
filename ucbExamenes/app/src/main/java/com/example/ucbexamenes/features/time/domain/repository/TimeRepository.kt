package com.example.ucbexamenes.features.time.domain.repository

import com.example.ucbexamenes.features.time.domain.model.ServerTime


interface TimeRepository {
    suspend fun getRealTime(): String
}