package com.example.thecookbook.category_list.data.repository

import com.example.thecookbook.category_list.data.mapper.toCategory
import com.example.thecookbook.category_list.data.remote.api.CategoryApi
import com.example.thecookbook.category_list.domain.model.Category
import com.example.thecookbook.category_list.domain.repository.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryApi: CategoryApi
) : CategoryRepository {

    override suspend fun getCategories(): List<Category> {
        return categoryApi.getCategories().categories.map { it.toCategory() }
    }
}