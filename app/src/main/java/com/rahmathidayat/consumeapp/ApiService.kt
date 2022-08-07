package com.rahmathidayat.consumeapp

import com.rahmathidayat.seafood.model.ModelFood
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("filter.php")
    suspend fun listSeaMeal(@Query("c") category: String): Response<ModelFood>

}