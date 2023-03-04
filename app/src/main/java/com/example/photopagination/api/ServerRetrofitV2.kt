package com.example.photopagination.api

import retrofit2.Retrofit

class ServerRetrofitV2 {

    companion object {
        private val retrofit : Retrofit
            get() {
            return RetrofitBuilder.getRetrofit()
        }

        val server : ApiServer
            get() = retrofit.create(ApiServer::class.java)
    }
}