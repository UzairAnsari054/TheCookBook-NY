package com.example.thecookbook.core.presentation

sealed class Screen {

    @kotlinx.serialization.Serializable
    data object CategoryScreen : Screen()

    @kotlinx.serialization.Serializable
    data class MealScreen(val category: String) : Screen()

    @kotlinx.serialization.Serializable
    data class MealDetailsScreen(val mealId: String) : Screen()
}