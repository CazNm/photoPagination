package com.example.photopagination.api

import com.example.photopagination.model.photo.Photo

class ServerConnector {
    suspend fun getPhotoList(pageNumber : Int) : List<Photo> = ServerRetrofitV2.server.getPhotos(pageNumber)
}

