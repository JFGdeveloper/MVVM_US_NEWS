package com.javidev.mvvm_compose.presentation.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavArgument
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.javidev.mvvm_compose.presentation.screens.detailScreen.DetailScreen
import com.javidev.mvvm_compose.presentation.screens.listScreen.ListScreen

@ExperimentalCoilApi
@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Destinos.ListScreen.route){
        // pantallas que voy a tener
        composable(route = Destinos.ListScreen.route){
            ListScreen(navController = navController)

        }

        composable(
            route = "${Destinos.DetailScreen.route}/{title}",
        ){
            // los argumentos estan en el it
            it.arguments?.getString("title")?.let {

                DetailScreen(title = it, navController = navController)

            }

        }
    }

}