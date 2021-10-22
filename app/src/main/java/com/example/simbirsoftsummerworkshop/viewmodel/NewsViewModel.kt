package com.example.simbirsoftsummerworkshop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.model.DatasServise

class NewsViewModel(private val service: DatasServise) : ViewModel() {
    private val _category: MutableLiveData<MutableList<Datas.FilterCategory>> by lazy {
        MutableLiveData<MutableList<Datas.FilterCategory>>()
    }

    val category: LiveData<MutableList<Datas.FilterCategory>> = _category

    private val _listNews: MutableLiveData<MutableList<Datas.News>> by lazy {
        MutableLiveData<MutableList<Datas.News>>()
    }

    val news: LiveData<MutableList<Datas.News>> = _listNews

    private val _news: MutableLiveData<Datas.News> by lazy {
        MutableLiveData<Datas.News>()
    }

    val detailNews: LiveData<Datas.News> = _news

    fun saveAndGetCategory(categoryList: MutableList<Datas.FilterCategory>): MutableList<Datas.FilterCategory> {
        val categorySort = service.sortCategory(categoryList)
        _category.value = categorySort
        return categorySort
    }

    fun saveNews(newList: MutableList<Datas.News>) {
        val saveList = service.getInstance().saveNews(newList)
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
