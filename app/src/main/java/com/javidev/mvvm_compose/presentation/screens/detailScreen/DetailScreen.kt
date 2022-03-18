package com.javidev.mvvm_compose.presentation.screens.detailScreen

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.javidev.mvvm_compose.R
import com.javidev.mvvm_compose.data.model.News
import com.javidev.mvvm_compose.presentation.screens.common.MyCard

@ExperimentalCoilApi
@Composable
fun DetailScreen(
    title: String,
    navController: NavController,
    viewModel: DetailScreenViewModel = hiltViewModel()
) {
    val new = viewModel.getTitle(title)

    //val new = viewModel.getNew()
    //val new = News("yo","campeon","conten","url","no hay foto")
    val context = LocalContext.current
    DetailContent(new.value, navController,context)
}

@ExperimentalCoilApi
@Composable
private fun DetailContent(new: News?, navController: NavController,context:Context) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = new?.title ?: "DetailScreen",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            navigationIcon = {
               IconButton(onClick = { navController.popBackStack() }) {
                   Icon(
                       imageVector = Icons.Default.ArrowBack,
                       contentDescription = null
                   )
               }
            }
        )
    }) { paddingValues ->
        new?.let {
            Column {
                MyCard(
                    new = new,
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .clickable {
                            // todo navegation
                        }
                )

                Button(modifier = Modifier.padding(start = 8.dp), onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(new.url))
                    context.startActivity(intent)
                }) {
                    Text(text = "ver mas..")
                }
            }

        }?: run {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ){
                //ProgressIndicatorDefaults
                CircularProgressIndicator()
            }
        }
    }
}


/////////// PREVIEW ////////////////////////////
@ExperimentalCoilApi
@Preview
@Composable
fun PrevDetailScreen() {
    val new = News(
        "yo",
        "el campeos",
        "llalalalalalallalal",
        "jsjsjsjjs",
        R.drawable.america_4628631_640.toString()
    )
    DetailContent(new, rememberNavController(), LocalContext.current)
}