package com.example.thecookbook.category_list.data.remote.api

import com.example.thecookbook.category_list.data.remote.model.CategoriesDto
import retrofit2.http.GET

interface CategoryApi {

    @GET("categories.php")
    suspend fun getCategories(): CategoriesDto
}