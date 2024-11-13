package com.example.thecookbook.meal_detail.domain.repository

import com.example.thecookbook.meal_detail.domain.model.MealDetail

interface MealDetailsRepository {
    suspend fun getMealDetails(mealId: String): List<MealDetail>
}