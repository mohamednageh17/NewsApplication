package com.example.data.remote

import com.example.data.models.remote.NewsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    fun fetchNews(@Query("country")countryName:String):Single<NewsResponse>
}