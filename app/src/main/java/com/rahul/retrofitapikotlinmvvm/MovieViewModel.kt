package com.rahul.retrofitapikotlinmvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rahul.retrofitapikotlinmvvm.model.Article
import com.rahul.retrofitapikotlinmvvm.model.MainModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {

    private var movieLiveData = MutableLiveData<List<Article>>()
    private val yourKey = "add your api key"

    fun getMoviesData(){
         RetrofitInstance.api.getMovieArticles("movies",yourKey)
             .enqueue(object : Callback<MainModel?> {
                 override fun onResponse(call: Call<MainModel?>, response: Response<MainModel?>) {
                     if (response.body()!=null){
                         movieLiveData.value = response.body()!!.articles
                     } else{
                         return
                     }
                 }

                 override fun onFailure(call: Call<MainModel?>, t: Throwable) {
                     Log.d("TAG",t.message.toString())
                 }
             })
    }

    fun observeMovieLiveData() : LiveData<List<Article>> {
        return movieLiveData
    }

}