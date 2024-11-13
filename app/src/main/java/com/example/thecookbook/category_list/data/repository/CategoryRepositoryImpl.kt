package com.example.thecookbook.category_list.data.repository

import com.example.thecookbook.category_list.data.local.CategoryDao
import com.example.thecookbook.category_list.data.mapper.toCategory
import com.example.thecookbook.category_list.data.mapper.toCategoryEntity
import com.example.thecookbook.category_list.data.remote.api.CategoryApi
import com.example.thecookbook.category_list.domain.model.Category
import com.example.thecookbook.category_list.domain.repository.CategoryRepository
import com.example.thecookbook.core.presentation.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryApi: CategoryApi,
    private val categoryDao: CategoryDao
) : CategoryRepository {

    override suspend fun getCategories(): Flow<Resource<List<Category>>> {
        return flow {
            emit(Resource.Loading(true))

            try {
                val categoryEntities = categoryApi.getCategories().categories.map { it.toCategoryEntity() }
                categoryDao.saveCategories(categoryEntities)

                val cachedCategories = categoryDao.getCategories().map { it.toCategory() }
                emit(Resource.Success(data = cachedCategories))
            } catch (e: Exception) {
                e.printStackTrace()

                val cachedCategories = categoryDao.getCategories().map { it.toCategory() }
                if (cachedCategories.isNotEmpty()) {
                    emit(Resource.Success(data = cachedCategories))
                } else {
                    emit(Resource.Error(errorMsg = "Failed to load categories, No network and no cached data"))
                }
            } finally {
                emit(Resource.Loading(false))
            }
        }
    }
}