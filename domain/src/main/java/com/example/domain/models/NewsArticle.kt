package com.example.domain.models

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsArticle(
    val articleSource: ArticleSource?=null,
    val author: String? = null,
    val title: String? = null,
    val description: String? = null,
    val url: String? = null,
    val urlToImage: String? = null,
    val publishedAt: String? = null,
    val content: String? = null
) : Parcelable

@Parcelize
data class ArticleSource (
    val id: String? = null,
    val name: String? = null
) : Parcelable