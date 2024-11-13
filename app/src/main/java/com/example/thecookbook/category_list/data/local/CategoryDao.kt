package com.example.thecookbook.category_list.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CategoryDao {

    @Insert
    suspend fun saveCategories(categories: List<CategoryEntity>)

    @Query("SELECT * FROM categoryentity")
    suspend fun getCategories(): List<CategoryEntity>
}