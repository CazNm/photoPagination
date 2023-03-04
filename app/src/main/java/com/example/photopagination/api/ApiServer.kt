package com.example.photopagination.api

import com.example.photopagination.model.photo.Photo
import retrofit2.http.GET
import retrofit2.http.Query


// Retrofit API Server

interface ApiServer {

    @GET(ConstData.getPhotoList)
    suspend fun getPhotos(
        @Query("page") pageNumber : Int,
        @Query("limit") limit : Int = 100
    ) : List<Photo>
}