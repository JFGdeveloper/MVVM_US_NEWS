package com.javidev.mvvm_compose.presentation.screens.listScreen

import android.util.Log
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.decode.withInterruptibleSource

@Composable
fun ListScreen(
    navController: NavController,
    viewModel: ListScreenViewModel = hiltViewModel()
) {

    Text(text = "hola javier")
    val news = viewModel.getNews()
    Log.d("javi", "///////////valor: ${news[0]}")

}


@Preview
@Composable
fun PrevListScreen() {
    ListScreen(navController = NavController(LocalContext.current))
}