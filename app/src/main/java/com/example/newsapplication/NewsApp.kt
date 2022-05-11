package com.example.newsapplication

import android.app.Application
import com.example.data.di.networkModule
import com.example.data.di.repositoryModule
import com.example.domain.di.newsByCategoryUseCaseModule
import com.example.domain.di.newsByCountryUseCaseModule
import com.example.newsapplication.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NewsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@NewsApp)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    newsByCountryUseCaseModule,
                    newsByCategoryUseCaseModule,
                    viewModelModule,
                )
            )
        }
    }
}