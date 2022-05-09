package com.example.newsapplication.viewmodel

import com.example.domain.models.NewsArticle
import com.example.domain.use_cases.GetNewsByCountryUseCase
import com.example.newsapplication.handle_state.StateLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class ArticlesViewModel(private val getNewsByCountryUseCase: GetNewsByCountryUseCase):BaseViewModel() {
    private val _articlesLiveData by lazy { StateLiveData<List<NewsArticle>>() }
    val articleLiveDate=_articlesLiveData

    init {
        getNewsByCountry("eg")
    }

    fun getNewsByCountry(countryName:String){
        getNewsByCountryUseCase(countryName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe{_articlesLiveData.postLoading()}
            .subscribe({
                       _articlesLiveData.postSuccess(it)
            },{
                _articlesLiveData.postError(it)
            }).addTo(compositeDisposable)
    }
}