package com.example.thecookbook.meal_detail.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.thecookbook.meal_detail.domain.model.MealDetail

@Dao
interface MealDetailDao {

    @Insert
    suspend fun insertMealDetailEntities(mealDetailList: List<MealDetailEntity>)

    @Query("SELECT * FROM mealdetailentity")
    suspend fun getMealDetailEntities(): List<MealDetailEntity>
}