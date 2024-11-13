package com.example.thecookbook.meal_list.domain.repository

import com.example.thecookbook.meal_list.domain.model.Meal

interface MealRepository {
    suspend fun getMealList(category: String): List<Meal>
}