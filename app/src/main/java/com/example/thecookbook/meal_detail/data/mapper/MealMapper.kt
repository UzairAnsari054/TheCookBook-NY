package com.example.thecookbook.meal_detail.data.mapper

import com.example.thecookbook.meal_detail.data.local.MealDetailEntity
import com.example.thecookbook.meal_detail.data.remote.model.MealDetailDto
import com.example.thecookbook.meal_detail.domain.model.MealDetail

fun MealDetailDto.toMealDetailEntity(): MealDetailEntity {
    return MealDetailEntity(
        idMeal = idMeal,
        strArea = strArea,
        strCategory = strCategory,
        strInstructions = strInstructions,
        strMeal = strMeal,
        strMealThumb = strMealThumb,
    )

}

fun MealDetailEntity.toMealDetail(): MealDetail {
    return MealDetail(
        idMeal = idMeal,
        strArea = strArea,
        strCategory = strCategory,
        strInstructions = strInstructions,
        strMeal = strMeal,
        strMealThumb = strMealThumb,
    )
}