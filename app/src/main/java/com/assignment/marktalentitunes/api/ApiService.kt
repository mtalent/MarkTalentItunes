package com.assignment.marktalentitunes.api

import com.assignment.marktalentitunes.model.ResultSongListing
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search?term=pop&amp;media=music&entity=song&limit=50")
    fun getPopSongs(
    ):  Call<ResultSongListing>
    @GET("search?term=classic&amp;media=music&entity=song&limit=50")
    fun getClassicSongs(
    ): Call<ResultSongListing>
    @GET("search?term=rock&amp;media=music&entity=song&limit=50")
    fun getRockSongs(
    ): Call<ResultSongListing>


            companion object {
        private var instance: Retrofit? = null


        fun createRetrofit(): Retrofit {
            if (instance == null) {
                instance =
                    Retrofit.Builder()
                        .baseUrl("https://itunes.apple.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }

            return instance!!
        }
    }


}