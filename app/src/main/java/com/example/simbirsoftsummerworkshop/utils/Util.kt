package com.example.simbirsoftsummerworkshop.utils

import android.util.Log
import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.storage.StorageNews
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

object Util {
    private fun relevanceDate(dataEnd: LocalDate): Boolean = dataEnd.isAfter(LocalDate.now())
    private fun isRelevanceDate(dataEnd: LocalDate): Int =
        dataEnd.dayOfYear - LocalDate.now().dayOfYear

    fun getTime(news: Datas.News): String {
        return if (relevanceDate(news.dateEnd)) {
            "Осталось ${isRelevanceDate(news.dateEnd)} дней " +
                    "(${
                        news.dateStart.format(
                            DateTimeFormatter.ofPattern(
                                "dd.MM"
                            )
                        )
                    }) - " + news.dateEnd.format(DateTimeFormatter.ofPattern("dd.MM"))
        } else {
            "${mounts[news.dateEnd.monthValue - 1]} " +
                    news.dateEnd.format(DateTimeFormatter.ofPattern("dd, yyyy"))
        }
    }

    private val mounts = listOf(
        "Январь",
        "Февраль",
        "Март",
        "Апрель",
        "Май",
        "Июнь",
        "Июль",
        "Август",
        "Сентябрь",
        "Октябрь",
        "Ноябрь",
        "Декабрь"
    )

    fun sortCategory(categoryList: List<Datas.FilterCategory>): List<Datas.FilterCategory> {
        val sortCategoryList = categoryList.filter { it.push } as MutableList
        Log.d("TEST", "size sortCategoryList: ${sortCategoryList.size}")
        return sortCategoryList
    }

    fun filterList(categoryList: List<Datas.FilterCategory>): List<Datas.News> {
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
            StorageNews().loadNewsList().filter { it.helpCategory == filteredNewsList }
        return resultList as MutableList
    }

}
