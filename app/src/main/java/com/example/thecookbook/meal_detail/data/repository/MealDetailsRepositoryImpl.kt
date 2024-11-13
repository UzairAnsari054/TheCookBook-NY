package com.example.thecookbook.meal_detail.data.repository

import com.example.thecookbook.meal_detail.data.mapper.toMealDetail
import com.example.thecookbook.meal_detail.data.remote.api.MealDetailApi
import com.example.thecookbook.meal_detail.domain.model.MealDetail
import com.example.thecookbook.meal_detail.domain.repository.MealDetailsRepository
import javax.inject.Inject

class MealDetailsRepositoryImpl @Inject constructor(
    private val mealDetailApi: MealDetailApi
) : MealDetailsRepository {

    override suspend fun getMealDetails(mealId: String): List<MealDetail> {
        return mealDetailApi.getMealDetails(mealId).mealDetailsList.map { it.toMealDetail() }
    }

}