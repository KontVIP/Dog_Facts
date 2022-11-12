package com.github.kontvip.lab3.domain

import com.github.kontvip.lab3.domain.model.Fact

interface DogFactInteractor {

    suspend fun getDogFact(): Fact

    class Base(private val repository: Repository): DogFactInteractor {

        override suspend fun getDogFact(): Fact = repository.getDogFacts(1)
    }

}