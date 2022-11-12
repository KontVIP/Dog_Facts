package com.example.retrofitapiguide.data.fact

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface FactApi {

    @Headers("Content-Type: application/json")
    @GET("/api/facts")
    suspend fun getDogFact(@Query("number") number: Int): Response<JsonObject>

}