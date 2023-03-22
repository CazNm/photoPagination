package com.example.photopagination

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.paging.LOG_TAG
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter

@Composable
fun PhotoViewCompose(activityViewModel : MainViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val pagingItems = activityViewModel.photoList.collectAsLazyPagingItems()
        LazyColumn {
            itemsIndexed(pagingItems) {_, photos ->
                Log.println(Log.DEBUG, "cazTest", "$photos")
                photos?.let {data ->
                    val config = LocalConfiguration.current
                    val width = config.screenWidthDp.dp
                    val height = (width * (data.height / data.width))

                    Box(modifier = Modifier
                        .height(height)
                        .fillMaxWidth()
                        .background(Color.Red)
                        .padding(bottom = 30.dp)
                    ) {
                        AsyncImage(
                            model = data.url,
                            contentDescription = "Author : ${data.author} / Download Url : ${data.downloadUrl}"
                        )

                    }
                }
            }
        }
    }

}