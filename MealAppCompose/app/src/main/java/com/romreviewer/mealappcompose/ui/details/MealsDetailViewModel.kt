package com.romreviewer.mealappcompose.ui.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.romreviewer.mealappcompose.model.MealsRepository
import com.romreviewer.mealappcompose.model.response.MealResponse

class MealsDetailViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    var mealState = mutableStateOf<MealResponse?>(null)
    private val repository = MealsRepository.getInstance()

    init {
        val mealId = savedStateHandle.get<String>("meal_category_id") ?: "Null"

        mealState.value = repository.getMeals(mealId)
    }
}