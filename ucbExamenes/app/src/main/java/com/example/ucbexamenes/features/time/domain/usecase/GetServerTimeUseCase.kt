package com.example.ucbexamenes.features.time.domain.usecase

import com.example.ucbexamenes.features.time.domain.repository.TimeRepository


class GetServerTimeUseCase(
    private val repository: TimeRepository
) {
    suspend operator fun invoke(): String {
        return repository.getRealTime()
    }
}