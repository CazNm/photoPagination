package com.example.photopagination

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.photopagination.model.photo.Photo
import com.example.photopagination.model.photo.PhotoPagingSource
import kotlinx.coroutines.flow.Flow

class MainViewModel : ViewModel() {

    val photoList : Flow<PagingData<Photo>> = Pager(PagingConfig(pageSize = 20)) {
        PhotoPagingSource()
    }.flow

}