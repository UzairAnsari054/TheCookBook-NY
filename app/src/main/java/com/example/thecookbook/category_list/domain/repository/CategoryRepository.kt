package com.example.thecookbook.category_list.domain.repository

import com.example.thecookbook.category_list.domain.model.Category

interface CategoryRepository {
    suspend fun getCategories(): List<Category>
}