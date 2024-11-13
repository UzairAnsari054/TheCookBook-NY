package com.example.thecookbook.meal_list.data.mapper

import com.example.thecookbook.meal_list.data.remote.model.MealDto
import com.example.thecookbook.meal_list.domain.model.Meal

fun MealDto.toMeal(): Meal {
    return Meal(
        idMeal = idMeal,
        strMeal = strMeal,
        strMealThumb = strMealThumb
    )
}