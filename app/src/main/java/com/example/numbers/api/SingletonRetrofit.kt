package com.example.numbers.api

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object SingletonRetrofit {

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl("http://numbersapi.com")
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()

    private val numbersApi : NumbersApi = retrofit.create(NumbersApi::class.java)

    fun getInstance(): NumbersApi {
        return numbersApi
    }

}