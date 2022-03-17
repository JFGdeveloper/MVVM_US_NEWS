package com.javidev.mvvm_compose.presentation.screens.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import com.javidev.mvvm_compose.data.model.News


@ExperimentalCoilApi
@Composable
 fun MyCard(new: News,modifier: Modifier= Modifier,onClick: ()->Unit = {}) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                  onClick()
                // todo pasar el title por aqui

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
