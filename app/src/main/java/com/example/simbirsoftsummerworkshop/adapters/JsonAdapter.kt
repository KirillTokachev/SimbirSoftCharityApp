package com.example.simbirsoftsummerworkshop.adapters

import android.content.Context
import android.content.res.AssetManager
import com.example.simbirsoftsummerworkshop.model.Datas
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class JsonAdapter {
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val type = Types.newParameterizedType(List::class.java, Datas.News::class.java)
    private val newsAdapter = moshi.adapter<List<Datas.News>>(type)

    fun getNews(context: Context): MutableList<Datas.News> {
        val jsonNews = context.assets.readFile("news.json")
        val news = newsAdapter.fromJson(jsonNews)!!
        return news.toMutableList()
    }

    private fun AssetManager.readFile(fileName: String): String =
        open(fileName).bufferedReader().use { it.readText() }
}
