package com.example.thecookbook.meal_detail.domain.usecase

import com.example.thecookbook.core.presentation.utils.Resource
import com.example.thecookbook.meal_detail.domain.model.MealDetail
import com.example.thecookbook.meal_detail.domain.repository.MealDetailsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMealDetailsUseCase @Inject constructor(
    private val mealDetailsRepository: MealDetailsRepository
) {
    suspend operator fun invoke(mealId: String): Flow<Resource<List<MealDetail>>> {
        return mealDetailsRepository.getMealDetails(mealId)
    }
}