package com.example.ucbexamenes.features.time.data

import android.os.SystemClock
import kotlinx.coroutines.delay

class RemoteTimeDataSource {

    private val serverStartHour = 12
    private val serverStartMinute = 0
    private val serverStartSecond = 0

    private val startUptime = SystemClock.elapsedRealtime()

    suspend fun fetchServerDateTime(): String {
        delay(300) // simula red

        val elapsedMillis = SystemClock.elapsedRealtime() - startUptime
        val elapsedSeconds = (elapsedMillis / 1000).toInt()

        val totalSeconds =
            serverStartHour * 3600 +
                    serverStartMinute * 60 +
                    serverStartSecond +
                    elapsedSeconds

        val hours = (totalSeconds / 3600) % 24
        val minutes = (totalSeconds / 60) % 60
        val seconds = totalSeconds % 60

        return String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }
}
