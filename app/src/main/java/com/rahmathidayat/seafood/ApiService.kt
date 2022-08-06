package com.rahmathidayat.seafood

import com.rahmathidayat.post.Post
import com.rahmathidayat.seafood.model.ModelFood
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("filter.php")
    suspend fun listSeaFood(@Query("c") category: String): Response<ModelFood>

    @GET("filter.php")
    suspend fun listSeaMeal(@Query("c") category: String): Response<ModelFood>

    @GET("posts/4")
    suspend fun getList(): Response<Post>

    @GET("/comments")
    suspend fun getComment(): Response<List<Comments>>
}