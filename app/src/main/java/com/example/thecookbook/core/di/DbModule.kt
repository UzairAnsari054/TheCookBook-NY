package com.example.thecookbook.core.di

import android.app.Application
import androidx.room.Room
import com.example.thecookbook.category_list.data.local.CategoryDao
import com.example.thecookbook.category_list.data.local.CategoryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Singleton
    @Provides
    fun provideCategoryDatabase(application: Application): CategoryDatabase {
        return Room.databaseBuilder(
            application,
            CategoryDatabase::class.java,
            "category_db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideCategoryDao(categoryDatabase: CategoryDatabase): CategoryDao {
        return categoryDatabase.getCategoryDao()
    }
}