package com.example.data.repositories

import com.example.data.mapper.mapToDomain
import com.example.data.remote.NewsApi
import com.example.domain.models.NewsArticle
import com.example.domain.repositories.NewsRepository
import io.reactivex.Single

class NewsRepositoryImp(private val newsApi: NewsApi):NewsRepository {
    override fun getArticlesByCountry(countryName: String): Single<List<NewsArticle>> {
        return newsApi.fetchNewsByCountry(countryName).map {
            it.mapToDomain()
        }
    }

    override fun getArticlesByCategory(category: String): Single<List<NewsArticle>> {
        return newsApi.fetchNewsByCategory(category).map {
            it.mapToDomain()
        }
    }
}