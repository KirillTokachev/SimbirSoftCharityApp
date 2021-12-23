package com.example.simbirsoftsummerworkshop.repository

import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.tasks.Task

typealias NewsListener = (List<Datas.News>) -> Unit

interface NewsRepository : Repository {
    fun loadNews(): Task<List<Datas.News>>

    fun saveNews(news: List<Datas.News>)

    override fun addListener(listener: Listener) {
        installListener(listener)
    }

    override fun removeListener(listener: Listener) {
        deleteListener(listener)
    }

    fun installListener(listener: NewsListener)

    fun deleteListener(listener: NewsListener)

    fun sortFilter(categoryList: List<Datas.FilterCategory>): List<Datas.News>

    fun categoryFilter(categoryList: List<Datas.FilterCategory>): List<Datas.FilterCategory>

    fun isEmptyNews(): List<Datas.News>
}