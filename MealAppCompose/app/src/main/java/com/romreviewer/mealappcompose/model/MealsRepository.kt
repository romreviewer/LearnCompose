package com.romreviewer.mealappcompose.model

import com.romreviewer.mealappcompose.model.api.RetrofitBuilder
import com.romreviewer.mealappcompose.model.response.MealResponse
import com.romreviewer.mealappcompose.model.response.MealsCategoryResponse

class MealsRepository {
    private val service = RetrofitBuilder.api
    private var cashedMeals = listOf<MealResponse>()
    suspend fun getMeals(): MealsCategoryResponse {
        val response=service.getMeals()
        cashedMeals=response.categories
        return response
    }

    fun getMeals(id: String) = cashedMeals.firstOrNull { it.id == id }


    companion object {
        @Volatile
        private var instance: MealsRepository? = null
        fun getInstance() = instance?: synchronized(this){
            instance?: MealsRepository().also { instance=it }
        }
    }
}