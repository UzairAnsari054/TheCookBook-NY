package com.example.thecookbook.meal_list.presentation

import com.example.thecookbook.meal_list.domain.model.Meal

data class MealState(
    val mealList: List<Meal> = emptyList()
)
