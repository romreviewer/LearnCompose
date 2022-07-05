package com.romreviewer.mealappcompose.ui.meals

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.romreviewer.mealappcompose.model.MealsRepository
import com.romreviewer.mealappcompose.model.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(application: Application) : AndroidViewModel(application) {
    val rememberedMeals: MutableState<List<MealResponse>> = mutableStateOf(emptyList())
    private val repository = MealsRepository.getInstance()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val meals = getMeals()
            rememberedMeals.value = meals
        }
    }

    private suspend fun getMeals(): List<MealResponse> {
        return repository.getMeals().categories
    }
}