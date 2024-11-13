package com.example.thecookbook.meal_list.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MealDao {

    @Insert
    suspend fun insertMealList(meals: List<MealEntity>)

    @Query("SELECT * FROM mealentity")
    suspend fun getMealList(): List<MealEntity>
}