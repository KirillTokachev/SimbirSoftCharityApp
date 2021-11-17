package com.example.simbirsoftsummerworkshop.view.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.repository.NewsListener
import com.example.simbirsoftsummerworkshop.repository.NewsRepository
import com.example.simbirsoftsummerworkshop.storage.StorageNews
import com.example.simbirsoftsummerworkshop.tasks.PendingResult
import com.example.simbirsoftsummerworkshop.tasks.Result
import com.example.simbirsoftsummerworkshop.tasks.SuccessResult
import com.example.simbirsoftsummerworkshop.tasks.takeSuccess
import com.example.simbirsoftsummerworkshop.utils.Util.filterList
import com.example.simbirsoftsummerworkshop.utils.Util.sortCategory
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

typealias LiveResult<T> = LiveData<Result<T>>
typealias MutableLiveResult<T> = MutableLiveData<Result<T>>

class NewsViewModel(
    private val repository: NewsRepository
) : ViewModel() {

    private val _listNews = MutableLiveResult<List<Datas.News>>(PendingResult())

    val news: LiveResult<List<Datas.News>> = _listNews

    private val _category: MutableLiveData<List<Datas.FilterCategory>> by lazy {
        MutableLiveData<List<Datas.FilterCategory>>()
    }
    val category: LiveData<List<Datas.FilterCategory>> = _category

    private val newsListener: NewsListener = {
        _listNews.postValue(SuccessResult(repository.loadNews()))
    }

    private val _detailNews = MutableLiveData<Datas.News>()

    val detailNews: LiveData<Datas.News> = _detailNews


    init {
        viewModelScope.launch {
            delay(2000)
            repository.addListener(newsListener)
        }
    }

    /*fun listOf(list: List<Datas.News>): Result<List<Datas.News>> {
        return
    }*/

    fun saveNews(newsList: List<Datas.News>) {
        _listNews.postValue(SuccessResult(newsList))
    }

    fun sortNews(categoryList: List<Datas.FilterCategory>): List<Datas.News> {
        val news = filterList(categoryList)
        saveNews(news)
        return news
    }

    fun saveAndInitDetailNews(news: Datas.News): Datas.News {
        _detailNews.value = news
        return news
    }

    fun saveAndInitCategory(categoryList: List<Datas.FilterCategory>): List<Datas.FilterCategory> {
        val categorySort = sortCategory(categoryList)
        _category.value = categorySort
        return categorySort
    }
}
