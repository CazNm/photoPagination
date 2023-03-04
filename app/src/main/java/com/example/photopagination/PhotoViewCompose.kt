package com.example.photopagination

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import coil.compose.rememberAsyncImagePainter

@Composable
fun PhotoViewCompose(activityViewModel : MainViewModel) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        val pagingItems = activityViewModel.photoList.collectAsLazyPagingItems()
        LazyColumn {
            itemsIndexed(pagingItems) {_, photos ->
                Box(modifier = Modifier
                    .height(photos?.height?.dp ?: 0.dp)
                    .width(photos?.width?.dp ?: 0.dp)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(model = photos?.url),
                        contentDescription = null
                    )
                }
            }
        }
    }

}