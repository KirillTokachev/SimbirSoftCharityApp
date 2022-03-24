package com.example.simbirsoftsummerworkshop.utils

import com.example.simbirsoftsummerworkshop.model.Datas
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

object Util {
    private fun relevanceDate(dataEnd: Long): Boolean =
        LocalDate.ofEpochDay(dataEnd).isAfter(LocalDate.now())

    private fun isRelevanceDate(dataEnd: Long): Int =
        LocalDate.ofEpochDay(dataEnd).dayOfYear - LocalDate.now().dayOfYear

    fun getTime(news: Datas.News): String {
        return if (relevanceDate(news.dateEnd)) {
            "Осталось ${isRelevanceDate(news.dateEnd)} дней " +
                    "(${
                        LocalDate.ofEpochDay(news.dateEnd).format(
                            DateTimeFormatter.ofPattern(
                                "dd.MM"
                            )
                        )
                    }) - " + LocalDate.ofEpochDay(news.dateEnd)
                .format(DateTimeFormatter.ofPattern("dd.MM"))
        } else {
            "${mounts[LocalDate.ofEpochDay(news.dateEnd).monthValue - 1]} " +
                    LocalDate.ofEpochDay(news.dateEnd)
                        .format(DateTimeFormatter.ofPattern("dd, yyyy"))
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
