package com.example.thecookbook.meal_detail.presentation

import com.example.thecookbook.meal_detail.domain.model.MealDetail

data class MealDetailsState(
    val mealDetails: List<MealDetail> = emptyList(),
    val errorMsg: String = "",
    val isMealDetailsLoading: Boolean = false
)
