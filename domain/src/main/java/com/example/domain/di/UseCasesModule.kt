package com.example.domain.di

import com.example.domain.repositories.NewsRepository
import com.example.domain.use_cases.GetNewsByCategoryUseCase
import com.example.domain.use_cases.GetNewsByCountryUseCase
import org.koin.dsl.module


val newsByCountryUseCaseModule= module {
    single {
        provideNewsByCountryUseCase(get())
    }
}
fun provideNewsByCountryUseCase(newsRepository: NewsRepository):GetNewsByCountryUseCase{
    return GetNewsByCountryUseCase(newsRepository)
}

val newsByCategoryUseCaseModule= module {
    single {
        provideNewsByCategoryUseCase(get())
    }
}
fun provideNewsByCategoryUseCase(newsRepository: NewsRepository):GetNewsByCategoryUseCase{
    return GetNewsByCategoryUseCase(newsRepository)
}