package com.javidev.mvvm_compose.presentation.screens.detailScreen

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.javidev.mvvm_compose.R
import com.javidev.mvvm_compose.data.model.News
import com.javidev.mvvm_compose.presentation.screens.common.MyCard

@Composable
fun DetailScreen(
    navController: NavController,
    viewModel: DetailScreenViewModel= hiltViewModel()
) {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "DetailScreen")})
    }) {
        MyCard(new = News("yo",
            "el puto amo",
            "content","urla",
            R.drawable.icons8_android_os_64.toString()) )
    }
}

@Preview
@Composable
fun PrevDetailScreen() {
    DetailScreen(rememberNavController() )
}