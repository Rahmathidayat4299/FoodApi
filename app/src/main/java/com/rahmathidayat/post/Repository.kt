package com.rahmathidayat.post

import com.rahmathidayat.seafood.Comments
import com.rahmathidayat.seafood.Meal
import com.rahmathidayat.seafood.ModelFood
import retrofit2.Call
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post> = Retrofit.api.getList()

//    suspend fun getListFood(categori: String): Response<List<ModelFood>> =
//        Retrofit.api.listSeaFood(categori)
}