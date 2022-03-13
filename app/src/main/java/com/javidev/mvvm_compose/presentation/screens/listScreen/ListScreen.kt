package com.javidev.mvvm_compose.presentation.screens.listScreen


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage

import com.javidev.mvvm_compose.R
import com.javidev.mvvm_compose.data.model.News
import com.javidev.mvvm_compose.presentation.screens.common.MyCard


@Composable
fun ListScreen(
    navController: NavController,
    viewModel: ListScreenViewModel = hiltViewModel()
) {
    val news = viewModel.getNews()
    MyScaffold(news = news)
}


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
        )
    )
}