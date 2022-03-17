package com.javidev.mvvm_compose.presentation.screens.navigation

sealed class Destinos(val route: String){

    
    object ListScreen: Destinos("list_screen")
    object DetailScreen: Destinos("detail_screen")
}