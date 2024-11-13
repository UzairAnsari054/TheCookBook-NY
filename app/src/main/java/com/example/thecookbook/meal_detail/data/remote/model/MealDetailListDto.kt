package com.example.thecookbook.meal_detail.data.remote.model

import com.google.gson.annotations.SerializedName

data class MealDetailListDto(
    @SerializedName("meals")
    val mealDetailsList: List<MealDetailDto>
)