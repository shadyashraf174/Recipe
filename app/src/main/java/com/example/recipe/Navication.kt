package com.example.recipe

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recipe.screens.RecipeDetails
import com.example.recipe.screens.RecipeHomeScreen

@SuppressLint("ComposableDestinationInComposeScope")
@Composable
fun ComposeNavigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "S_1") {
        composable("S_1") {
            RecipeHomeScreen()
        }
        composable("S_2") {
            RecipeDetails(navController)
        }
    }
}