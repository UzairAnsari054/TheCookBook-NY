package com.example.thecookbook.meal_list.domain.repository

import com.example.thecookbook.core.presentation.utils.Resource
import com.example.thecookbook.meal_list.domain.model.Meal
import kotlinx.coroutines.flow.Flow

interface MealRepository {
    suspend fun getMealList(category: String): Flow<Resource<List<Meal>>>
}