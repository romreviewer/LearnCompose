package com.romreviewer.mealappcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.romreviewer.mealappcompose.ui.details.MealDetailsScreen
import com.romreviewer.mealappcompose.ui.details.MealsDetailViewModel
import com.romreviewer.mealappcompose.ui.meals.MealsCategoriesScreen
import com.romreviewer.mealappcompose.ui.theme.MealAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealAppComposeTheme {
                // A surface container using the 'background' color from the theme
                FoodsApp()
            }
        }
    }
}

@Composable
private fun FoodsApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "destination_meals_list") {
        composable(route = "destination_meals_list") {
            MealsCategoriesScreen() {
                navController.navigate("destination_meals_details/$it")
            }
        }
        composable(
            route = "destination_meals_details/{meal_category_id}",
            arguments = listOf(navArgument("meal_category_id") {
                type = NavType.StringType
            })
        ) {
            val viewModel: MealsDetailViewModel = viewModel()
            MealDetailsScreen(mealResponse = viewModel.mealState.value)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealAppComposeTheme {
        MealsCategoriesScreen{

        }
    }
}