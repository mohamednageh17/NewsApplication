package com.example.domain.use_cases

import com.example.domain.repositories.NewsRepository

class GetNewsByCategoryUseCase(private val newsRepository: NewsRepository) {
    operator fun invoke(category:String)=newsRepository.getArticlesByCategory(category)
}