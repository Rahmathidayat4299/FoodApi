package com.rahmathidayat.consumeapp

import com.rahmathidayat.seafood.model.ModelFood
import retrofit2.Response

class Repository {

    suspend fun getListFood(categori: String): Response<ModelFood> =
        Retrofit.api.listSeaMeal(categori)
}