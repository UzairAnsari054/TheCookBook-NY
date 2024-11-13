package com.example.thecookbook.meal_list.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MealEntity::class],
    version = 1
)
abstract class MealDatabase : RoomDatabase() {

    abstract fun getMealDao(): MealDao
}