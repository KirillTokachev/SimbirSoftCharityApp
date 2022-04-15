package com.example.simbirsoftsummerworkshop.view.news

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.simbirsoftsummerworkshop.App
import com.example.simbirsoftsummerworkshop.adapters.JsonAdapter
import com.example.simbirsoftsummerworkshop.data_base.AppDataBase
import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.network.ServerApi
import com.example.simbirsoftsummerworkshop.storage.NewsRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class NewsViewModel(
    private val application: App
) : AndroidViewModel(application) {
    private val _listNews = MutableLiveData<List<Datas.News>>()
    val news: LiveData<List<Datas.News>> = _listNews

    private val _category: MutableLiveData<List<Datas.FilterCategory>> by lazy {
        MutableLiveData<List<Datas.FilterCategory>>()
    }

    val flag = MutableLiveData<Boolean>()

    private val repository: NewsRepository

    private val compositeDisposable = CompositeDisposable()

    private val _detailNews = MutableLiveData<Datas.News>()
    val detailNews: LiveData<Datas.News> = _detailNews

    init {
        val newsDao = AppDataBase.getDataBase(application).getNewsDao()
        repository = NewsRepository(newsDao)
        flag.value = false
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun initFlag(boolean: Boolean) {
        flag.value = boolean
    }

    fun loadNews() {
        repository.loadNews()
    }

    private fun saveNews(newsList: List<Datas.News>) {
        _listNews.postValue(newsList)
        repository.saveNews(newsList)
    }

    fun fetchNews(serverApi: ServerApi) {
        compositeDisposable.add(
            serverApi.getNewsList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    saveNews(it)
                }, {
                    saveNews(JsonAdapter(application.applicationContext).getNews())
                })
        )
    }

    fun sortNews(categoryList: List<Datas.FilterCategory>): List<Datas.News> {
        val news = repository.sortFilter(categoryList)
        _listNews.postValue(news)
        saveNews(news)
        return news
    }

    fun saveAndInitDetailNews(news: Datas.News): Datas.News {
        _detailNews.value = news
        return news
    }

    fun saveAndInitCategory(categoryList: List<Datas.FilterCategory>): List<Datas.FilterCategory> {
        val categorySort = repository.categoryFilter(categoryList)
        _category.value = categorySort
        return categorySort
    }
}
