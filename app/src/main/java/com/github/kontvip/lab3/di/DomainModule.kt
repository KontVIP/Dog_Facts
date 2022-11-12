package com.github.kontvip.lab3.di

import com.github.kontvip.lab3.domain.DogFactInteractor
import com.github.kontvip.lab3.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideDogFactInteractor(repository: Repository): DogFactInteractor =
        DogFactInteractor.Base(repository = repository)
}