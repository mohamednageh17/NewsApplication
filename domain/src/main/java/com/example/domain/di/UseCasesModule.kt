package com.example.domain.di

import com.example.domain.repositories.NewsRepository
import com.example.domain.use_cases.GetNewsByCountryUseCase
import org.koin.dsl.module


val useCaseModule= module {
    single {
        provideUseCase(get())
    }
}
fun provideUseCase(newsRepository: NewsRepository):GetNewsByCountryUseCase{
    return GetNewsByCountryUseCase(newsRepository)
}