package com.example.thecookbook.meal_detail.data.repository

import com.example.thecookbook.core.presentation.utils.Resource
import com.example.thecookbook.meal_detail.data.local.MealDetailDao
import com.example.thecookbook.meal_detail.data.mapper.toMealDetail
import com.example.thecookbook.meal_detail.data.mapper.toMealDetailEntity
import com.example.thecookbook.meal_detail.data.remote.api.MealDetailApi
import com.example.thecookbook.meal_detail.domain.model.MealDetail
import com.example.thecookbook.meal_detail.domain.repository.MealDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MealDetailsRepositoryImpl @Inject constructor(
    private val mealDetailApi: MealDetailApi,
    private val mealDetailDao: MealDetailDao
) : MealDetailsRepository {

    override suspend fun getMealDetails(mealId: String): Flow<Resource<List<MealDetail>>> = flow {
        emit(Resource.Loading(true))

        try {
            val mealDetailEntities = mealDetailApi.getMealDetails(mealId).mealDetailsList.map { it.toMealDetailEntity() }
            mealDetailDao.insertMealDetailEntities(mealDetailEntities)

            val cachedMealDetailList =
                mealDetailDao.getMealDetailEntities().map { it.toMealDetail() }
            emit(Resource.Success(data = cachedMealDetailList))
        } catch (e: Exception) {
            e.printStackTrace()
            val cachedMealDetailList =
                mealDetailDao.getMealDetailEntities().map { it.toMealDetail() }
            if (cachedMealDetailList.isNotEmpty()) {
                emit(Resource.Success(data = cachedMealDetailList))
            } else {
                emit(Resource.Error(errorMsg = "Failed to load meal details. No network and no cached data"))
            }
        } finally {
            emit(Resource.Loading(false))
        }
    }

}