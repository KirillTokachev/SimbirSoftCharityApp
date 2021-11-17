package com.example.simbirsoftsummerworkshop.storage

import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.repository.NewsListener
import com.example.simbirsoftsummerworkshop.repository.NewsRepository

class StorageNews : NewsRepository {
    companion object {
        private var newsList = listOf<Datas.News>()
    }

    fun setNews(news: List<Datas.News>) {
        newsList = news
    }

    fun loadNewsList(): List<Datas.News> = newsList

    private val listeners = mutableSetOf<NewsListener>()

    override fun loadNews(): List<Datas.News> {
        return loadNewsList()
    }

    override fun saveNews(news: List<Datas.News>) {
        setNews(news)
    }

    override fun addListener(listener: NewsListener) {
        listeners += listener
        listener(loadNews())
    }

    override fun removeListener(listener: NewsListener) {
        listeners -= listener
    }
}