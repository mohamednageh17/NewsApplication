package com.example.domain.use_cases

import com.example.domain.repositories.NewsRepository

class GetNewsByCountryUseCase(private val newsRepository: NewsRepository) {
    operator fun invoke(countryName:String)=newsRepository.getArticlesByCountry(countryName)
}