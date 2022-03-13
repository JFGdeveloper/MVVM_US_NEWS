package com.javidev.mvvm_compose.presentation.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.javidev.mvvm_compose.MyApplication_GeneratedInjector

@Composable
fun MyApp() {
    val navController = rememberNavController()
    AppNavigation(navController)
}