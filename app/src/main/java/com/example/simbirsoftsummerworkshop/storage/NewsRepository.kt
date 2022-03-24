package com.example.simbirsoftsummerworkshop.storage

import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.repository.NewsDao
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class NewsRepository(
    private val newsDao: NewsDao
) {

    private var newsList = listOf<Datas.News>()

    fun loadNews(): Single<List<Datas.News>> = newsDao.loadNews()

    fun saveNews(news: List<Datas.News>): Completable {
        newsList = news
        return newsDao.saveNews(news)
    }

    fun sortFilter(categoryList: List<Datas.FilterCategory>): List<Datas.News> {
        return filterList(categoryList)
    }

    fun categoryFilter(categoryList: List<Datas.FilterCategory>): List<Datas.FilterCategory> {
        return sortCategory(categoryList)
    }

    private fun sortCategory(categoryList: List<Datas.FilterCategory>): List<Datas.FilterCategory> {
        val sortCategoryList = categoryList.filter { it.push } as MutableList
        return sortCategoryList
    }

    private fun filterList(categoryList: List<Datas.FilterCategory>): List<Datas.News> {
        val newCategoryList = sortCategory(categoryList)
        val sortStringCategory = filterListToStringList(newCategoryList)
        return filterNews(sortStringCategory)
    }

    private fun filterListToStringList(categoryList: List<Datas.FilterCategory>): List<String> {
        val helpList: MutableList<String> = mutableListOf()
        categoryList.map { helpList.add(it.name) }
        return helpList
    }

    private fun filterNews(filteredNewsList: List<String>): List<Datas.News> {
        val resultList = newsList.filter { it.helpCategory == filteredNewsList }
        return resultList as MutableList
    }
}
