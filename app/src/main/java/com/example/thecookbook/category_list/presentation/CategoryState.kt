package com.example.thecookbook.category_list.presentation

import com.example.thecookbook.category_list.domain.model.Category

data class CategoryState(
    val categories: List<Category> = emptyList(),
    val errorMsg: String = "",
    val isLoadingCategories: Boolean = false
)
