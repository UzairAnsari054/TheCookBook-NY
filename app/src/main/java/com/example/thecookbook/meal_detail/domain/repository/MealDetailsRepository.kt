package com.example.thecookbook.meal_detail.domain.repository

import com.example.thecookbook.core.presentation.utils.Resource
import com.example.thecookbook.meal_detail.domain.model.MealDetail
import kotlinx.coroutines.flow.Flow

interface MealDetailsRepository {
    suspend fun getMealDetails(mealId: String): Flow<Resource<List<MealDetail>>>
}