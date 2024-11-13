package com.example.thecookbook.meal_list.data.mapper

import com.example.thecookbook.meal_list.data.local.MealEntity
import com.example.thecookbook.meal_list.data.remote.model.MealDto
import com.example.thecookbook.meal_list.domain.model.Meal

fun MealDto.toMealEntity(): MealEntity {
    return MealEntity(
        idMeal = idMeal,
        strMeal = strMeal,
        strMealThumb = strMealThumb
    )
}

fun MealEntity.toMeal(): Meal {
    return Meal(
        idMeal = idMeal,
        strMeal = strMeal,
        strMealThumb = strMealThumb
    )
}