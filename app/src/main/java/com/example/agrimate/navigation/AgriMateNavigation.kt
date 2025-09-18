package com.example.agrimate.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.agrimate.ui.screens.AddActivityScreen
import com.example.agrimate.ui.screens.AddExpenseScreen
import com.example.agrimate.ui.screens.ActivitiesScreen
import com.example.agrimate.ui.screens.CropDetailsScreen
import com.example.agrimate.ui.screens.CropGuidesScreen
import com.example.agrimate.ui.screens.DashboardScreen
import com.example.agrimate.ui.screens.ExpensesScreen
import com.example.agrimate.ui.screens.SettingsScreen
import com.example.agrimate.ui.screens.SplashScreen

@Composable
fun AgriMateNavigation() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it / 3 },
                animationSpec = tween(300)
            ) + fadeIn(animationSpec = tween(300))
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -it / 3 },
                animationSpec = tween(200)
            ) + fadeOut(animationSpec = tween(200))
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -it / 3 },
                animationSpec = tween(300)
            ) + fadeIn(animationSpec = tween(300))
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it / 3 },
                animationSpec = tween(200)
            ) + fadeOut(animationSpec = tween(200))
        }
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.Dashboard.route) {
            DashboardScreen(navController = navController)
        }
        composable(Screen.CropGuides.route) {
            CropGuidesScreen(navController = navController)
        }
        composable(Screen.CropDetails.route) { backStackEntry ->
            val cropId = backStackEntry.arguments?.getString("cropId")?.toIntOrNull() ?: 0
            CropDetailsScreen(navController = navController, cropId = cropId)
        }
        composable(Screen.Activities.route) {
            ActivitiesScreen(navController = navController)
        }
        composable(Screen.AddActivity.route) {
            AddActivityScreen(navController = navController)
        }
        composable(Screen.Expenses.route) {
            ExpensesScreen(navController = navController)
        }
        composable(Screen.AddExpense.route) {
            AddExpenseScreen(navController = navController)
        }
        composable(Screen.Settings.route) {
            SettingsScreen(navController = navController)
        }
    }
}

