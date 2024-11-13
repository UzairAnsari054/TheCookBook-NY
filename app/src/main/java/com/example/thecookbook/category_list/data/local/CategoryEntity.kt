package com.example.thecookbook.category_list.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CategoryEntity(
    @PrimaryKey(autoGenerate = false)
    val idCategory: String = "",
    val strCategory: String = "",
    val strCategoryDescription: String = "",
    val strCategoryThumb: String = ""
)