package com.example.agrimate.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Dashboard : Screen("dashboard")
    object CropGuides : Screen("crop_guides")
    object CropDetails : Screen("crop_details/{cropId}") {
        fun createRoute(cropId: Int) = "crop_details/$cropId"
    }
    object Activities : Screen("activities")
    object AddActivity : Screen("add_activity")
    object Expenses : Screen("expenses")
    object AddExpense : Screen("add_expense")
    object Settings : Screen("settings")
}

