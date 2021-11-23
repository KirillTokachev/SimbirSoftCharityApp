package com.example.simbirsoftsummerworkshop.storage

import android.util.Log
import com.example.simbirsoftsummerworkshop.dispatchers.ThreadUtils
import com.example.simbirsoftsummerworkshop.factories.TaskFactory
import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.repository.NewsListener
import com.example.simbirsoftsummerworkshop.repository.NewsRepository
import com.example.simbirsoftsummerworkshop.tasks.Task

class StorageNews(
    private val taskFactory: TaskFactory,
    private val threadUtils: ThreadUtils
) : NewsRepository {
    companion object {
        private var newsList = listOf<Datas.News>()
    }

    private fun setNews(news: List<Datas.News>) {
        newsList = news
    }

    private fun getNews() = newsList

    private fun loadNewsList(): List<Datas.News> = newsList

    private val listeners = mutableSetOf<NewsListener>()

    fun isNewsEmpty() = newsList

    override fun loadNews(): Task<List<Datas.News>> = taskFactory.async {
        threadUtils.sleep(1000)
        return@async loadNewsList()
    }

    override fun saveNews(news: List<Datas.News>) {
        setNews(news)
    }

    override fun addListener(listener: NewsListener) {
        listeners += listener
    }

    override fun removeListener(listener: NewsListener) {
        listeners -= listener
    }

    override fun sortFilter(categoryList: List<Datas.FilterCategory>): List<Datas.News> {
        return filterList(categoryList)
    }

    override fun categoryFilter(categoryList: List<Datas.FilterCategory>): List<Datas.FilterCategory> {
        return sortCategory(categoryList)
    }

    override fun isEmptyNews(): List<Datas.News> {
        return getNews()
    }

    private fun sortCategory(categoryList: List<Datas.FilterCategory>): List<Datas.FilterCategory> {
        val sortCategoryList = categoryList.filter { it.push } as MutableList
        Log.d("TEST", "size sortCategoryList: ${sortCategoryList.size}")
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
        val resultList =
            StorageNews(taskFactory, threadUtils).getNews()
                .filter { it.helpCategory == filteredNewsList }
        return resultList as MutableList
    }
}