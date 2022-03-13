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


@Composable
fun ListScreen(
    navController: NavController,
    viewModel: ListScreenViewModel = hiltViewModel()
) {
    val news = viewModel.news

    Scaffold( news)


}

@Composable
private fun Scaffold( news: List<News>) {


    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = stringResource(id = R.string.app_name)) })
        }
    ) {
        LazyColumn {
            items(news) { new ->
                MyCard(new)
            }
        }

    }
}

@ExperimentalCoilApi
@Composable
private fun MyCard(new: News) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                //todo navegar a screen next
            },
        shape = RoundedCornerShape(12.dp),
        elevation = 12.dp,
        border = BorderStroke(1.dp, MaterialTheme.colors.primary)

    ) {

        Column {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(6.dp),
                model = new.urlToImage,
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )


            Column(modifier = Modifier.fillMaxWidth().padding(6.dp)) {
                new.title?.let { Text(text = it, fontSize = 18.sp, fontWeight = FontWeight.Bold) }
                new.content?.let {  Text(text = it, maxLines = 3, overflow = TextOverflow.Ellipsis) }
            }
        }

    }
}


@Preview
@Composable
fun PrevListScreen() {
    Scaffold(
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