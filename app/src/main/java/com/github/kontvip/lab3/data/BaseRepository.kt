package com.github.kontvip.lab3.data

import com.example.retrofitapiguide.data.fact.FactApi
import com.github.kontvip.lab3.domain.Repository
import com.github.kontvip.lab3.domain.model.Fact

class BaseRepository(private val factApi: FactApi) : Repository {

    override suspend fun getDogFacts(number: Int): Fact {
        val result = factApi.getDogFact(number)

        return if (result.isSuccessful) {
            val jsonObject = result.body()

            if (jsonObject != null) {
                Fact(jsonObject.get("facts").asString)
            }
            else {
                Fact("")
            }
        } else {
            Fact("")
        }
    }

}