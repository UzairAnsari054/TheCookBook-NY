package com.example.thecookbook.meal_detail.data.remote.api

import com.example.thecookbook.meal_detail.data.remote.model.MealDetailListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MealDetailApi {

    @GET("lookup.php")
    suspend fun getMealDetails(
        @Query("i") mealId: String
    ): MealDetailListDto
}