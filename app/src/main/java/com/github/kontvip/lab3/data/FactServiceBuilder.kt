package com.github.kontvip.lab3.data

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FactServiceBuilder {

    private val client = OkHttpClient.Builder().build()

    private var gson = GsonBuilder()
        .setLenient()
        .create()

    private val factRetrofit = Retrofit.Builder()
        .baseUrl("https://dog-api.kinduff.com/") // тут пишемо лінку на нашу АПІшку
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .build()


    fun <T> buildService(service: Class<T>): T {
        return factRetrofit.create(service)
    }

}