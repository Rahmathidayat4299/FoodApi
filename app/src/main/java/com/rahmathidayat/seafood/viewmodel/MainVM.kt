package com.rahmathidayat.seafood.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahmathidayat.consumeapp.Repository
import com.rahmathidayat.seafood.model.Meal
import kotlinx.coroutines.launch


class MainVM(private val repository: Repository) : ViewModel() {


    private val list = MutableLiveData<ArrayList<Meal>>()
    fun listSeaFood(categori: String): LiveData<ArrayList<Meal>> {
        viewModelScope.launch {
            val food = repository.getListFood(categori)
            try {
                if (food.isSuccessful) {
                    list.postValue(food.body()?.meals as ArrayList<Meal>?)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return list
    }

}





