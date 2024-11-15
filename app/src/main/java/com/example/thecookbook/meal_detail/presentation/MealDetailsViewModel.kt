package com.example.thecookbook.meal_detail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thecookbook.core.presentation.utils.Resource
import com.example.thecookbook.meal_detail.domain.usecase.GetMealDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealDetailsViewModel @Inject constructor(
    private val getMealDetailsUseCase: GetMealDetailsUseCase
) : ViewModel() {

    private val _mealDetailState = MutableStateFlow(MealDetailsState())
    val mealDetailState = _mealDetailState.asStateFlow()

    fun loadMealDetails(mealId: String) {
        viewModelScope.launch {
            getMealDetailsUseCase(mealId).collect { result ->
                when (result) {
                    is Resource.Error -> {
                        _mealDetailState.update {
                            it.copy(errorMsg = result.errorMsg ?: "")
                        }
                    }

                    is Resource.Loading -> {
                        _mealDetailState.update {
                            it.copy(isMealDetailsLoading = result.isLoading)
                        }
                    }

                    is Resource.Success -> {
                        _mealDetailState.update {
                            it.copy(mealDetails = result.data ?: emptyList())
                        }
                    }
                }

            }
        }
    }
}