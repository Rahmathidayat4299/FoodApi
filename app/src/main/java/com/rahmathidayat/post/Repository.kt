package com.rahmathidayat.post

import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post> = Retrofit.api.getList()
}