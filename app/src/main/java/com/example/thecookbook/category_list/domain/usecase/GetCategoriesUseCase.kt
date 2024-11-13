package com.example.thecookbook.category_list.domain.usecase

import com.example.thecookbook.category_list.domain.model.Category
import com.example.thecookbook.category_list.domain.repository.CategoryRepository
import com.example.thecookbook.core.presentation.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<Category>>> {
        return categoryRepository.getCategories()
    }
}