package com.example.thecookbook.meal_list.data.repository

import com.example.thecookbook.meal_list.data.mapper.toMeal
import com.example.thecookbook.meal_list.data.remote.api.MealApi
import com.example.thecookbook.meal_list.domain.model.Meal
import com.example.thecookbook.meal_list.domain.repository.MealRepository
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val mealApi: MealApi
) : MealRepository {

    override suspend fun getMealList(category: String): List<Meal> {
        return mealApi.getMealList(category).meals.map { it.toMeal() }
    }

}