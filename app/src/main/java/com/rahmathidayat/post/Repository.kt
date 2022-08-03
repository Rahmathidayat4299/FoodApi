package com.rahmathidayat.post

class Repository {
        suspend fun getPost(): Post = Retrofit.api.getList()
}