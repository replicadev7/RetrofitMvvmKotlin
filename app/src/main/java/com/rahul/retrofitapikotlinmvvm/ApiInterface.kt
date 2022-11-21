package com.rahul.retrofitapikotlinmvvm

import com.rahul.retrofitapikotlinmvvm.model.MainModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("v2/everything/")
    fun getMovieArticles(@Query("q") query: String?, @Query("apikey") apiKey: String?): Call<MainModel>
}