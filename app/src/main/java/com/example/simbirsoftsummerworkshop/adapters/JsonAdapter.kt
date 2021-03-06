package com.example.simbirsoftsummerworkshop.adapters

import android.content.Context
import android.content.res.AssetManager
import com.example.simbirsoftsummerworkshop.model.Datas
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

private const val NEWS_PATH = "news.json"
private const val CATEGORY_PATH = "category.json"

class JsonAdapter(var context: Context) {
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val typeNews = Types.newParameterizedType(List::class.java, Datas.News::class.java)
    private val newsAdapter = moshi.adapter<List<Datas.News>>(typeNews)
    private val typeCategory =
        Types.newParameterizedType(List::class.java, Datas.HelpCategory::class.java)
    private val categoryAdapter = moshi.adapter<List<Datas.HelpCategory>>(typeCategory)

    fun getNews(): List<Datas.News> {
        val jsonNews = context.assets.readFile(NEWS_PATH)
        val news = newsAdapter.fromJson(jsonNews)!!
        return news.toList()
    }

    fun getCategory(): List<Datas.HelpCategory> {
        val jsonCategory = context.assets.readFile(CATEGORY_PATH)
        val category = categoryAdapter.fromJson(jsonCategory)!!
        return category.toList()
    }

    fun getEvents(): List<Datas.Event> {
        val events = mutableListOf<Datas.Event>()
        val jsonNews = context.assets.readFile(NEWS_PATH)
        newsAdapter.fromJson(jsonNews)!!.forEach {
            val event = Datas.Event(it.name)
            events.add(event)
        }
        return events
    }

    private fun AssetManager.readFile(fileName: String): String =
        open(fileName).bufferedReader().use { it.readText() }
}
