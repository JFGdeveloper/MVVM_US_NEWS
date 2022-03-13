package com.javidev.mvvm_compose.presentation.screens.navigation

sealed class AppRoutes(val route: String){

    object ListScreen: AppRoutes("list_screen")
    object DetailScreen: AppRoutes("detail_screen")
}