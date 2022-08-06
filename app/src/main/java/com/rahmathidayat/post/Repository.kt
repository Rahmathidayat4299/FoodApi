package com.rahmathidayat.post

import com.rahmathidayat.seafood.model.ModelFood
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post> = Retrofit.api.getList()

    suspend fun getListFood(categori: String): Response<ModelFood> =
        Retrofit.api.listSeaMeal(categori)
}