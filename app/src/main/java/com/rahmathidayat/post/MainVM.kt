package com.rahmathidayat.post

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahmathidayat.seafood.Comments
import com.rahmathidayat.seafood.Meal
import com.rahmathidayat.seafood.ModelFood
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainVM(private val repository: Repository) : ViewModel() {
    //    val dataPost: MutableLiveData<Response<Post>> = MutableLiveData()
//    val dataFood: MutableLiveData<Response<List<ModelFood>>> = MutableLiveData()
//    fun getPost() {
//        viewModelScope.launch {
//            val response = repository.getPost()
//            dataPost.value = response
//        }
//    }
//
//    fun listFood(categori: String) {
//        viewModelScope.launch {
//            val response = repository.getListFood(categori)
//            dataFood.value = response
//        }
//    }
    private val list = MutableLiveData<ArrayList<Meal>>()


    fun getUser(category: String): LiveData<ArrayList<Meal>> {
        Retrofit.api
            .listSeaFood(category)
            .enqueue(object : Callback<ModelFood>{
                override fun onResponse(call: Call<ModelFood>, response: Response<ModelFood>) {
                    if (response.isSuccessful){
                        list.postValue(response.body()?.meals as ArrayList<Meal>)
                    }
                }

                override fun onFailure(call: Call<ModelFood>, t: Throwable) {
                    Log.e(TAG, t.message.toString() )
                }

            })
        return list
    }
}




