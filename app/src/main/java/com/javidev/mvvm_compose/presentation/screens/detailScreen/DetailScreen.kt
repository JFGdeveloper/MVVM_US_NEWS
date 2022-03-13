package com.javidev.mvvm_compose.presentation.screens.detailScreen

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun DetailScreen() {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "DetailScreen")})
    }) {

    }
}