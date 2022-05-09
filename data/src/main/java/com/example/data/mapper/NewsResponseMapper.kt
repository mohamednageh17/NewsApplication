package com.example.data.mapper

import com.example.data.models.remote.NewsResponse
import com.example.domain.models.ArticleSource
import com.example.domain.models.NewsArticle

fun NewsResponse.mapToDomain()=this.articles?.map {
    NewsArticle(
        articleSource = ArticleSource(it.source.id,it.source.name),
        author = it.author,
        title = it.title,
        description =it.description,
        url =it.url,
        urlToImage = it.urlToImage,
        publishedAt = it.publishedAt,
        content = it.content)
}