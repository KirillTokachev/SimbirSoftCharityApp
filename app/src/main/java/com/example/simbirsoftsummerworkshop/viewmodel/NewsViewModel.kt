package com.example.simbirsoftsummerworkshop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.model.DataServise

class NewsViewModel(private val service: DataServise) : ViewModel() {
    private val _category: MutableLiveData<List<Datas.FilterCategory>> by lazy {
        MutableLiveData<List<Datas.FilterCategory>>()
    }

    val category: LiveData<List<Datas.FilterCategory>> = _category

    private val _listNews: MutableLiveData<List<Datas.News>> by lazy {
        MutableLiveData<List<Datas.News>>()
    }

    val news: LiveData<List<Datas.News>> = _listNews

    private val _news: MutableLiveData<Datas.News> by lazy {
        MutableLiveData<Datas.News>()
    }

    val detailNews: LiveData<Datas.News> = _news

    fun saveAndGetCategory(categoryList: MutableList<Datas.FilterCategory>): MutableList<Datas.FilterCategory> {
        val categorySort = service.sortCategory(categoryList)
        _category.value = categorySort
        return categorySort
    }

    fun saveNews(newList: List<Datas.News>) {
        val saveList = service.saveNews(newList)
        _listNews.value = saveList
    }

    fun sortNews(categoryList: MutableList<Datas.FilterCategory>): MutableList<Datas.News> {
        val news = service.filterList(categoryList)
        _listNews.value = news
        saveNews(news)
        return news
    }

    fun saveAndInitDetailNews(news: Datas.News): Datas.News {
        _news.value = news
        return news
    }
}
