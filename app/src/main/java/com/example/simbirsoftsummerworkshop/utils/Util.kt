package com.example.simbirsoftsummerworkshop.utils

import com.example.simbirsoftsummerworkshop.model.Datas
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

object Util {
    private fun relevanceDate(dataEnd: LocalDate): Boolean = dataEnd.isAfter(LocalDate.now())
    private fun isRelevanceDate(dataEnd: LocalDate): Int =
        dataEnd.dayOfYear - LocalDate.now().dayOfYear

    fun getTime(news: Datas.News): String {
        return when (relevanceDate(news.dateEnd)) {
            true -> {
                "Осталось ${isRelevanceDate(news.dateEnd)} дней " +
                        "(${
                            news.dateStart.format(
                                DateTimeFormatter.ofPattern(
                                    "dd.MM"
                                )
                            )
                        }) - " + news.dateEnd.format(DateTimeFormatter.ofPattern("dd.MM"))
            }
            false -> {
                "${mounts[news.dateEnd.monthValue - 1]} " +
                        news.dateEnd.format(DateTimeFormatter.ofPattern("dd, yyyy"))
            }
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
}
