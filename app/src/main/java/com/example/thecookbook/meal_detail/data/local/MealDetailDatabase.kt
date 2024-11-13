package com.example.thecookbook.meal_detail.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MealDetailEntity::class],
    version = 1
)
abstract class MealDetailDatabase : RoomDatabase() {
    abstract fun getMealDetailDao(): MealDetailDao
}