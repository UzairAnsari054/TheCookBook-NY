package com.example.thecookbook.core.di

import com.example.thecookbook.category_list.data.remote.api.CategoryApi
import com.example.thecookbook.category_list.data.repository.CategoryRepositoryImpl
import com.example.thecookbook.category_list.domain.repository.CategoryRepository
import com.example.thecookbook.core.presentation.utils.Constants.BASE_URL
import com.example.thecookbook.meal_list.data.remote.api.MealApi
import com.example.thecookbook.meal_list.data.repository.MealRepositoryImpl
import com.example.thecookbook.meal_list.domain.repository.MealRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideCategoryApi(): CategoryApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(CategoryApi::class.java)
    }

    @Singleton
    @Provides
    fun provideMealApi(): MealApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(MealApi::class.java)
    }

    @Singleton
    @Provides
    fun provideCategoryRepository(categoryRepositoryImpl: CategoryRepositoryImpl): CategoryRepository {
        return categoryRepositoryImpl
    }

    @Singleton
    @Provides
    fun provideMealRepository(mealRepositoryImpl: MealRepositoryImpl): MealRepository {
        return mealRepositoryImpl
    }
}