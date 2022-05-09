package com.example.data.di

import com.example.data.remote.NewsApi
import com.example.data.repositories.NewsRepositoryImp
import com.example.domain.repositories.NewsRepository
import org.koin.dsl.module


val repositoryModule= module {
    single {
        provideNewsRepository(get())
    }
}
fun provideNewsRepository(remoteDataSource: NewsApi):NewsRepository{
    return NewsRepositoryImp(remoteDataSource)
}