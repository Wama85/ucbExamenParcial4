package com.example.ucbexamenes.di

import android.content.Context
import com.example.ucbexamenes.features.time.data.datasource.TimeRemoteDataSource
import com.example.ucbexamenes.features.time.data.repository.TimeRepositoryImpl
import com.example.ucbexamenes.features.time.domain.usecase.GetServerTimeUseCase
import com.example.ucbexamenes.features.time.presentation.TimeViewModel

object AppModule {

    fun provideTimeViewModel(context: Context): TimeViewModel {
        val dataSource = TimeRemoteDataSource()
        val repo = TimeRepositoryImpl(context, dataSource)
        val useCase = GetServerTimeUseCase(repo)
        return TimeViewModel(useCase)
    }
}
