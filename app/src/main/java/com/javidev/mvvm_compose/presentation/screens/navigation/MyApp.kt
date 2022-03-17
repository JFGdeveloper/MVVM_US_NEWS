package com.javidev.mvvm_compose.presentation.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.javidev.mvvm_compose.MyApplication_GeneratedInjector

@ExperimentalCoilApi
@Composable
fun MyApp() {
    val navController = rememberNavController()
    AppNavigation(navController)
}