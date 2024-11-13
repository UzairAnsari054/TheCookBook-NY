package com.example.thecookbook.meal_list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thecookbook.meal_list.domain.usecase.GetMealListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealListViewModel @Inject constructor(
    private val getMealListUseCase: GetMealListUseCase
) : ViewModel() {

    private val _mealListState = MutableStateFlow(MealState())
    val mealList = _mealListState.asStateFlow()

    fun loadMealList(category: String) {
        viewModelScope.launch {
            _mealListState.update {
                it.copy(mealList = getMealListUseCase(category))
            }
        }
    }
}