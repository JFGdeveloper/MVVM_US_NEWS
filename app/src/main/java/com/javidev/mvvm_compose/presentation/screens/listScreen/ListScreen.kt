package com.javidev.mvvm_compose.presentation.screens.listScreen


import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi

import com.javidev.mvvm_compose.data.model.News


@ExperimentalCoilApi
@Composable
fun ListScreen(
    navController: NavController,
    viewModel: ListScreenViewModel = hiltViewModel()
) {
    val news = viewModel.getNews()
    MyScaffold(news = news,navController)
}




//////////////// PREVIEW /////////////////
@Preview
@Composable
fun PrevListScreen() {
    MyScaffold(
        news = arrayListOf(
            News(
                "yo",
                "ls mio",
                "esto es uan reelelon del mi caso",
                "http:/mica", "lalal"
            ),
            News(
                "yo",
                "ls mio",
                "esto es uan reelelon del mi caso,esto es uan reelelon del mi caso," +
                        "esto es uan reelelon del mi caso,esto es uan reelelon del mi caso",
                "http:/mica", "lalal"
            )
        ),
        rememberNavController()
    )
}