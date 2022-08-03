package com.rahmathidayat.seafood


import com.google.gson.annotations.SerializedName

data class ModelFood(
    @SerializedName("meals")
    val meals: List<Meal>
)