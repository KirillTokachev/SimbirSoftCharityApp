package com.example.simbirsoftsummerworkshop.adapters

import android.content.Context
import android.content.res.AssetManager
import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.view.news.NewsFragment
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

private const val NEWS_PATH = "news.json"
private const val CATEGORY_PATH = "category.json"

class JsonAdapter {
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val typeNews = Types.newParameterizedType(List::class.java, Datas.News::class.java)
    private val newsAdapter = moshi.adapter<List<Datas.News>>(typeNews)
    private val typeCategory = Types.newParameterizedType(List::class.java, Datas.HelpCategory::class.java)
    private val categoryAdapter = moshi.adapter<List<Datas.HelpCategory>>(typeCategory)

    fun getNews(context: Context): List<Datas.News> {
        val jsonNews = context.assets.readFile(NEWS_PATH)
        val news = newsAdapter.fromJson(jsonNews)!!
        return news.toMutableList()
    }

    fun getCategory(context: Context): List<Datas.HelpCategory> {
        val jsonCategory = context.assets.readFile(CATEGORY_PATH)
        val category = categoryAdapter.fromJson(jsonCategory)!!
        return category.toMutableList()
    }

    private fun AssetManager.readFile(fileName: String): String =
        open(fileName).bufferedReader().use { it.readText() }
}
