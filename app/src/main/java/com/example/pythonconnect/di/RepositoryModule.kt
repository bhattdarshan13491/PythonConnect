package com.example.pythonconnect.di

import com.example.pythonconnect.data.repository.PredictRepositoryImpl
import com.example.pythonconnect.data.repository.PredictionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindObjectRepo(impl: PredictRepositoryImpl): PredictionRepository
}