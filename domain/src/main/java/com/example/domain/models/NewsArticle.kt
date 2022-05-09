package com.example.domain.models

data class NewsArticle(
    val articleSource: ArticleSource?=null,
    val author: String? = null,
    val title: String? = null,
    val description: String? = null,
    val url: String? = null,
    val urlToImage: String? = null,
    val publishedAt: String? = null,
    val content: String? = null
)

data class ArticleSource (
    val id: String? = null,
    val name: String? = null
)