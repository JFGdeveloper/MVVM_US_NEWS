package com.javidev.mvvm_compose.presentation.screens.listScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.javidev.mvvm_compose.R
import com.javidev.mvvm_compose.data.model.News
import com.javidev.mvvm_compose.presentation.screens.common.MyCard

@Composable
fun MyScaffold( news: List<News>) {
    androidx.compose.material.Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = stringResource(id = R.string.app_name)) })
        }
    ) {
        LazyColumn {
            items(news) { new ->
                MyCard(new = new)
            }
        }

    }
}