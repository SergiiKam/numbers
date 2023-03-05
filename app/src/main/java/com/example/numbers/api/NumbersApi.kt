package com.example.numbers.api

import retrofit2.http.GET
import retrofit2.http.Path

interface NumbersApi {

    @GET("/{number}")
    suspend fun getNumberDetails(@Path("number") number: Int) : String

    @GET("random/math")
    suspend fun getRandomNumberDetails() : String

}