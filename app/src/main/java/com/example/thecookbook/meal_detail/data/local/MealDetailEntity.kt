package com.example.thecookbook.meal_detail.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MealDetailEntity(
    @PrimaryKey(autoGenerate = false)
    val idMeal: String,
    val strArea: String,
    val strCategory: String,
    val strInstructions: String,
    val strMeal: String,
    val strMealThumb: String,
)