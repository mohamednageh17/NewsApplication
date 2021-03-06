package com.example.data.di

import com.example.data.models.remote.ApiKeyInterceptor
import com.example.data.remote.NewsApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL="https://newsapi.org/v2/"


val networkModule = module {
    single { provideInterceptor() }
    single { provideApiKeyInterceptor() }
    single {
        provideOkHttpClient(
            get(),
            get()
        )
    }
    single {
        provideApi(
            get()
        )
    }
    single {
        provideRetrofit(
            get()
        )
    }
}

fun provideInterceptor(): Interceptor {
    return HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)
}
fun provideApiKeyInterceptor(): ApiKeyInterceptor {
    return ApiKeyInterceptor()
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build()
}

fun provideOkHttpClient(interceptor: Interceptor, apiKeyInterceptor: ApiKeyInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .addInterceptor(apiKeyInterceptor)
        .build()
}

fun provideApi(retrofit: Retrofit): NewsApi = retrofit.create(NewsApi::class.java)