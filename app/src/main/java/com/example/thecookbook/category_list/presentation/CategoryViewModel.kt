package com.example.thecookbook.category_list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thecookbook.category_list.domain.usecase.GetCategoriesUseCase
import com.example.thecookbook.core.presentation.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {

    private val _categoriesState = MutableStateFlow((CategoryState()))
    val categoriesState = _categoriesState.asStateFlow()

    fun loadCategories() {
        viewModelScope.launch {
            getCategoriesUseCase().collect { result ->
                when (result) {
                    is Resource.Error -> {
                        _categoriesState.update {
                            it.copy(errorMsg = result.errorMsg ?: "")
                        }
                    }

                    is Resource.Loading -> {
                        _categoriesState.update {
                            it.copy(isLoadingCategories = result.isLoading)
                        }
                    }

                    is Resource.Success -> {
                        _categoriesState.update {
                            it.copy(categories = result.data ?: emptyList())
                        }
                    }
                }
            }
        }
    }
}