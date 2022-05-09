package com.example.data.models.remote

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class NewsResponse(
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("totalResults")
    val totalResults: Long? = null,
    @SerializedName("articles")
    val articles: List<Article>? = null
)

@Keep
data class Article(
    @SerializedName("source")
    val source: Source,
    @SerializedName("author")
    val author: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("urlToImage")
    val urlToImage: String? = null,
    @SerializedName("publishedAt")
    val publishedAt: String? = null,
    @SerializedName("content")
    val content: String? = null
)

@Keep
data class Source (
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null
)
