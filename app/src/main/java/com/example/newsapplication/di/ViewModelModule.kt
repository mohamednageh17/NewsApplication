package com.example.newsapplication.di

import com.example.newsapplication.viewmodel.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule= module {
    viewModel {
        ArticlesViewModel(get(),get())
    }
}