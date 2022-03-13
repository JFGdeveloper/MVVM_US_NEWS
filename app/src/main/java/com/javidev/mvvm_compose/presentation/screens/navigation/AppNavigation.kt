package com.javidev.mvvm_compose.presentation.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.javidev.mvvm_compose.presentation.screens.detailScreen.DetailScreen
import com.javidev.mvvm_compose.presentation.screens.listScreen.ListScreen

@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = AppRoutes.ListScreen.route){
        // pantallas que voy a tener
        composable(route = AppRoutes.ListScreen.route){
            ListScreen(navController = navController)

        }

        composable(route = AppRoutes.DetailScreen.route+"/{newTitle}"){
            DetailScreen(navController = navController)
        }
    }

}