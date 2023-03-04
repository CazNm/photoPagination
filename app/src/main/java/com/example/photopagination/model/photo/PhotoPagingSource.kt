package com.example.photopagination.model.photo

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.photopagination.api.ServerRetrofitV2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class PhotoPagingSource() : PagingSource<Int, Photo>() {
    companion object {
        const val STARTING_KEY = 0
    }
    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return 0
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> = suspendCoroutine { continuation ->
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val page = params.key ?: 1
                val photoResponse = ServerRetrofitV2.server.getPhotos(page)
                continuation.resume(LoadResult.Page(
                    data = photoResponse,
                    prevKey = if (page == 1) null else page - 1,
                    nextKey = page.plus(1)
                ))

            } catch (e: Exception) {
                continuation.resume(
                    LoadResult.Error(e)
                )
            }
        }
    }
}