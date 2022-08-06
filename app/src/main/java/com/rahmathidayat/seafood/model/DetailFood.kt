package com.rahmathidayat.seafood.model


import com.google.gson.annotations.SerializedName

data class DetailFood(
    @SerializedName("meals")
    val meals: List<MealX>
)