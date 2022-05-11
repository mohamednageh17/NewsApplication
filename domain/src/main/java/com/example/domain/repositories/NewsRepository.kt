package com.example.domain.repositories

import com.example.domain.models.NewsArticle
import io.reactivex.Single

interface NewsRepository {
    fun getArticlesByCountry(countryName:String):Single<List<NewsArticle>>

    fun getArticlesByCategory(category:String):Single<List<NewsArticle>>
}