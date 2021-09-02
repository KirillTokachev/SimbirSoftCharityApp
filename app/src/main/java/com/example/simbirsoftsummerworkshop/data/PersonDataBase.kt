package com.example.simbirsoftsummerworkshop.data

import android.graphics.BitmapFactory
import android.content.res.Resources

import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.model.User
import java.time.LocalDate

class PersonDataBase(resource: Resources) {

    private val friendsList = listOf(
            User(
                "Дмитрий Валерьевич",
                LocalDate.of(1992, 3, 13),
                "Хирург",
                BitmapFactory.decodeResource(resource,R.drawable.avatar),
                mutableListOf()
            ),
            User(
                "Евгений Александров",
                LocalDate.of(1991, 12, 12),
                "Терапевт",
                BitmapFactory.decodeResource(resource,R.drawable.avatar_1),
                mutableListOf()
            ),
            User(
                "Виктор Кузницов",
                LocalDate.of(1988, 5, 7),
                "Плотник",
                BitmapFactory.decodeResource(resource,R.drawable.avatar_2),
                mutableListOf()
            )
        )


    var person: User = User(
        "Константинов Денис",
        LocalDate.of(1980, 2, 1),
        "Хирургия, трамвотология",
        BitmapFactory.decodeResource(resource,R.drawable.image_man),
        friendsList as MutableList<User>,
        true
    )



}
