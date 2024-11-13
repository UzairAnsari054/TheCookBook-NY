package com.example.thecookbook.category_list.domain.usecase

import com.example.thecookbook.category_list.domain.model.Category
import com.example.thecookbook.category_list.domain.repository.CategoryRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {
    suspend operator fun invoke(): List<Category> {
        return categoryRepository.getCategories()
    }
}