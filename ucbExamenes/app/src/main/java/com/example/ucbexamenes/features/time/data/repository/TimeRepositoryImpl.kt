package com.example.ucbexamenes.features.time.data.repository

import android.content.Context
import com.example.ucbexamenes.features.time.data.datasource.TimeRemoteDataSource

import com.example.ucbexamenes.features.time.domain.repository.TimeRepository
import com.example.ucbexamenes.utils.NetworkUtils
import org.threeten.bp.LocalTime
import org.threeten.bp.format.DateTimeFormatter

class TimeRepositoryImpl(
    private val context: Context,
    private val remote: TimeRemoteDataSource
) : TimeRepository {

    override suspend fun getRealTime(): String {

        // 1️⃣ Si no hay internet → usar hora local del sistema
        if (!NetworkUtils.isOnline(context)) {
            return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
        }

        // 2️⃣ Si hay internet → usar hora del servidor
        return remote.fetchTimeFromServer()
    }
}
