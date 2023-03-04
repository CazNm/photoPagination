package com.example.photopagination

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.photopagination.ui.theme.PhotoPaginationTheme

class MainActivity : ComponentActivity() {

    val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoPaginationTheme {
                PhotoViewCompose(activityViewModel = viewModel)
            }
        }
    }
}
