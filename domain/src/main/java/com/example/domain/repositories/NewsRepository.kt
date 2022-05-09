package com.example.domain.repositories

import com.example.domain.models.NewsArticle
import io.reactivex.Single

interface NewsRepository {
    fun getNews(countryName:String):Single<List<NewsArticle>>
}