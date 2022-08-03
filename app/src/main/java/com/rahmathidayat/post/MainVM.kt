package com.rahmathidayat.post

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainVM(private val repository: Repository) : ViewModel() {
    val dataPost: MutableLiveData<Post> = MutableLiveData()
    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            dataPost.value = response
        }
    }
}