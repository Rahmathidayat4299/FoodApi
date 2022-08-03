package com.rahmathidayat.post

import com.rahmathidayat.seafood.ApiService
import com.rahmathidayat.seafood.Constan
import com.rahmathidayat.seafood.Constan.apiUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {

    val api = Retrofit.Builder()
        .baseUrl(apiUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)
}