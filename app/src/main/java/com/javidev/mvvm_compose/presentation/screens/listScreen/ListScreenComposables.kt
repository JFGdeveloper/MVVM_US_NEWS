package com.javidev.mvvm_compose.presentation.screens.listScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.javidev.mvvm_compose.R
import com.javidev.mvvm_compose.data.model.News
import com.javidev.mvvm_compose.presentation.screens.common.MyCard
import com.javidev.mvvm_compose.presentation.screens.navigation.Destinos

@ExperimentalCoilApi
@Composable
fun MyScaffold( news: List<News>,navController: NavController) {
    androidx.compose.material.Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = stringResource(id = R.string.app_name)) })
        }
    ) {
        LazyColumn {
            items(news) { new ->
                MyCard(new = new){
                    navController.navigate("${Destinos.DetailScreen.route}/${new.title}")
                }
            }
        }

    }
}