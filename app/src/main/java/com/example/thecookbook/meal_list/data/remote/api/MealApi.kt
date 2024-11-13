package com.example.thecookbook.meal_list.data.remote.api

import com.example.thecookbook.meal_list.data.remote.model.MealListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {

    @GET("filter.php")
    suspend fun getMealList(
        @Query("c") category: String
    ): MealListDto
}
