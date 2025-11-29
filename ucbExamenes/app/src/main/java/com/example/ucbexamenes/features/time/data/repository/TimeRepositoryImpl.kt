package com.example.ucbexamenes.features.time.data.repository

import com.example.ucbexamenes.features.time.data.datasource.TimeRemoteDataSource

import com.example.ucbexamenes.features.time.domain.repository.TimeRepository

class TimeRepositoryImpl(
    private val remote: TimeRemoteDataSource
) : TimeRepository {

    override suspend fun getRealTime(): String {
        return remote.fetchTimeFromServer()
    }
}
