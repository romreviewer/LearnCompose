package com.romreviewer.mealappcompose.model.api

import com.romreviewer.mealappcompose.model.response.MealsCategoryResponse
import retrofit2.http.GET

class MealsApiService {

    interface MealsApi {
        @GET("categories.php")
        suspend fun getMeals(): MealsCategoryResponse
    }
}