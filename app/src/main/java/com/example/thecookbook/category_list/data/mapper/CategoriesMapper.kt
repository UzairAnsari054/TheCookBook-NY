package com.example.thecookbook.category_list.data.mapper

import com.example.thecookbook.category_list.data.remote.model.CategoryDto
import com.example.thecookbook.category_list.domain.model.Category

fun CategoryDto.toCategory(): Category {
    return Category(
        idCategory = idCategory,
        strCategory = strCategory,
        strCategoryThumb = strCategoryThumb,
        strCategoryDescription = strCategoryDescription
    )
}