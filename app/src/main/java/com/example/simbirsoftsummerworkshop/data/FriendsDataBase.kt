package com.example.simbirsoftsummerworkshop.data

import com.example.simbirsoftsummerworkshop.R
import java.time.LocalDate

class FriendsDataBase {

    companion object {
        val friendsList = listOf(
            Person("Дмитрий Валерьевич",
                LocalDate.of(1992,3,13),
                "Хирург",
                R.drawable.avatar),
            Person("Евгений Александров",
                LocalDate.of(1991,12,12),
                "Терапевт",
                R.drawable.avatar_2),
            Person("Виктор Кузницов",
                LocalDate.of(1988,5,7),
                "Плотник",
                R.drawable.avatar_1)
        )
    }

}