package com.github.kontvip.lab3.di

import com.example.retrofitapiguide.data.fact.FactApi
import com.github.kontvip.lab3.data.BaseRepository
import com.github.kontvip.lab3.data.FactServiceBuilder
import com.github.kontvip.lab3.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideRepository(factApi: FactApi): Repository = BaseRepository(factApi = factApi)

    @Provides
    @Singleton
    fun provideFactApi(): FactApi =FactServiceBuilder.buildService(FactApi::class.java)
}