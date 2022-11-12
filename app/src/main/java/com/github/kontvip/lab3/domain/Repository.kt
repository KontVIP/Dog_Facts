package com.github.kontvip.lab3.domain

import com.github.kontvip.lab3.domain.model.Fact

interface Repository {

    suspend fun getDogFacts(number: Int): Fact
}