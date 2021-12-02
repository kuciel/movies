package com.andysworkshop.movies.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface IRetrofitApiInterface {

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/"

        fun create(): IRetrofitApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(IRetrofitApiInterface::class.java)
        }
    }

}