package com.example.data.remote

import com.example.data.models.remote.NewsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    fun fetchNewsByCountry(@Query("country")countryName:String="eg",
                           @Query("pageSize")pageSize:Int=100):Single<NewsResponse>

    @GET("top-headlines")
    fun fetchNewsByCategory(@Query("category")countryName:String,
                            @Query("pageSize")pageSize:Int=100):Single<NewsResponse>
}