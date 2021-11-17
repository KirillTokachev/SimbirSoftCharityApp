package com.example.simbirsoftsummerworkshop.repository

import com.example.simbirsoftsummerworkshop.model.Datas

typealias NewsListener = (List<Datas.News>) -> Unit

interface NewsRepository {

    fun loadNews(): List<Datas.News>

    fun saveNews(news: List<Datas.News>)

    fun addListener(listener: NewsListener)

    fun removeListener(listener: NewsListener)

}