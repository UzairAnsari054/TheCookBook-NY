package com.example.thecookbook.category_list.data.mapper

import com.example.thecookbook.category_list.data.local.CategoryEntity
import com.example.thecookbook.category_list.data.remote.model.CategoryDto
import com.example.thecookbook.category_list.domain.model.Category

fun CategoryDto.toCategoryEntity(): CategoryEntity {
    return CategoryEntity(
        idCategory = idCategory,
        strCategory = strCategory,
        strCategoryThumb = strCategoryThumb,
        strCategoryDescription = strCategoryDescription
    )
}

fun CategoryEntity.toCategory(): Category {
    return Category(
        idCategory = idCategory,
        strCategory = strCategory,
        strCategoryThumb = strCategoryThumb,
        strCategoryDescription = strCategoryDescription
    )
}