package com.example.simbirsoftsummerworkshop.view.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.simbirsoftsummerworkshop.dispatchers.Dispatcher
import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.repository.NewsListener
import com.example.simbirsoftsummerworkshop.repository.NewsRepository
import com.example.simbirsoftsummerworkshop.tasks.PendingResult
import com.example.simbirsoftsummerworkshop.tasks.SuccessResult
import com.example.simbirsoftsummerworkshop.view.fragments.BaseViewModel
import com.example.simbirsoftsummerworkshop.view.fragments.LiveResult
import com.example.simbirsoftsummerworkshop.view.fragments.MutableLiveResult

class NewsViewModel(
    private val repository: NewsRepository,
    dispatcher: Dispatcher
) : BaseViewModel(dispatcher) {
    private val _listNews = MutableLiveResult<List<Datas.News>>(PendingResult())
    val news: LiveResult<List<Datas.News>> = _listNews

    private val _category: MutableLiveData<List<Datas.FilterCategory>> by lazy {
        MutableLiveData<List<Datas.FilterCategory>>()
    }

    private val newsListener: NewsListener = {
        _listNews.postValue(SuccessResult(it))
    }

    private val _detailNews = MutableLiveData<Datas.News>()

    val detailNews: LiveData<Datas.News> = _detailNews


    init {
        repository.addListener(newsListener)
        load()
    }

    private fun load() {
        repository.loadNews().into(_listNews)
    }

    fun saveNews(newsList: List<Datas.News>) {
        _listNews.postValue(SuccessResult(newsList))
    }

    fun initNews(news: List<Datas.News>) {
        repository.saveNews(news)
    }

    fun isEmptyNews(): Boolean {
        return repository.isEmptyNews()
    }

    fun sortNews(categoryList: List<Datas.FilterCategory>): List<Datas.News> {
        val news = repository.sortFilter(categoryList)
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
