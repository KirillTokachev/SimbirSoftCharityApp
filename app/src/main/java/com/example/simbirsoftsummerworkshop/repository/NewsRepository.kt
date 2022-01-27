package com.example.simbirsoftsummerworkshop.repository

import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.tasks.Task

typealias NewsListener = (List<Datas.News>) -> Unit

interface NewsRepository {
    fun loadNews(): Task<List<Datas.News>>

    fun saveNews(news: List<Datas.News>)

    fun addListener(listener: NewsListener)

    fun removeListener(listener: NewsListener)

    fun sortFilter(categoryList: List<Datas.FilterCategory>): List<Datas.News>

    fun categoryFilter(categoryList: List<Datas.FilterCategory>): List<Datas.FilterCategory>

    fun isEmptyNews(): List<Datas.News>
}