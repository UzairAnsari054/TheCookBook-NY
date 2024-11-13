package com.example.thecookbook.meal_list.domain.usecase

import com.example.thecookbook.core.presentation.utils.Resource
import com.example.thecookbook.meal_list.domain.model.Meal
import com.example.thecookbook.meal_list.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMealListUseCase @Inject constructor(
    private val mealRepository: MealRepository
) {
    suspend operator fun invoke(category: String): Flow<Resource<List<Meal>>> {
        return mealRepository.getMealList(category)
    }
}