package com.example.ucbexamenes.di

import com.example.ucbexamenes.features.time.data.datasource.TimeRemoteDataSource
import com.example.ucbexamenes.features.time.data.repository.TimeRepositoryImpl
import com.example.ucbexamenes.features.time.domain.usecase.GetServerTimeUseCase
import com.example.ucbexamenes.features.time.presentation.TimeViewModel

object AppModule {

    private val dataSource = TimeRemoteDataSource()
    private val repository = TimeRepositoryImpl(dataSource)
    private val getTimeUseCase = GetServerTimeUseCase(repository)

    fun provideTimeViewModel() = TimeViewModel(getTimeUseCase)
}
