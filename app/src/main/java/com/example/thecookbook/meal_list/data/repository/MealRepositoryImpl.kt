package com.example.thecookbook.meal_list.data.repository

import com.example.thecookbook.core.presentation.utils.Resource
import com.example.thecookbook.meal_list.data.local.MealDao
import com.example.thecookbook.meal_list.data.mapper.toMeal
import com.example.thecookbook.meal_list.data.mapper.toMealEntity
import com.example.thecookbook.meal_list.data.remote.api.MealApi
import com.example.thecookbook.meal_list.domain.model.Meal
import com.example.thecookbook.meal_list.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val mealApi: MealApi,
    private val mealDao: MealDao
) : MealRepository {

    override suspend fun getMealList(category: String): Flow<Resource<List<Meal>>> = flow {
        emit(Resource.Loading(true))

        try {
            val mealEntities = mealApi.getMealList(category).meals.map { it.toMealEntity() }
            mealDao.insertMealList(mealEntities)

            val cachedMeals = mealDao.getMealList().map { it.toMeal() }
            emit(Resource.Success(data = cachedMeals))
        } catch (e: Exception) {
            e.printStackTrace()

            val cachedMeals = mealDao.getMealList().map { it.toMeal() }
            if (cachedMeals.isNotEmpty()) {
                emit(Resource.Success(data = cachedMeals))
            } else {
                emit(Resource.Error(errorMsg = "Failed to load meals, No network and no cached data"))
            }
        } finally {
            emit(Resource.Loading(false))
        }
    }

}