package com.example.simbirsoftsummerworkshop.data

import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.model.User
import java.time.LocalDate

class FriendsDataBase {

    companion object {
        val friendsList = listOf(
            User(
                "Дмитрий Валерьевич",
                LocalDate.of(1992, 3, 13),
                "Хирург",
                R.drawable.avatar
            ),
            User(
                "Евгений Александров",
                LocalDate.of(1991, 12, 12),
                "Терапевт",
                R.drawable.avatar_2
            ),
            User(
                "Виктор Кузницов",
                LocalDate.of(1988, 5, 7),
                "Плотник",
                R.drawable.avatar_1
            )
        )
    }
}
