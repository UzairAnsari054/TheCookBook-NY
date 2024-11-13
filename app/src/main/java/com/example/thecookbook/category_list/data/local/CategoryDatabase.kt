package com.example.thecookbook.category_list.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CategoryEntity::class],
    version = 1
)
abstract class CategoryDatabase: RoomDatabase() {
    abstract fun getCategoryDao(): CategoryDao
}