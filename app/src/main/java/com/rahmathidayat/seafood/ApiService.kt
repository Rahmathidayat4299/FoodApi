package com.rahmathidayat.seafood

import com.rahmathidayat.post.Post
import com.rahmathidayat.seafood.Constan.FILTER
import org.w3c.dom.Comment
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(FILTER)
    fun listSeaFood(@Query("c") category: String): Call<List<ModelFood>>

    @GET("posts/3")
    suspend fun getList(): Post

    @GET("/comments")
    fun getComment(): Response<List<Comments>>
}