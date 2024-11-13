package com.example.thecookbook.category_list.domain.repository

import com.example.thecookbook.category_list.domain.model.Category
import com.example.thecookbook.core.presentation.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun getCategories(): Flow<Resource<List<Category>>>
}