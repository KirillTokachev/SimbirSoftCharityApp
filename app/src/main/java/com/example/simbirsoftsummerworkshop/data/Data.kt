package com.example.simbirsoftsummerworkshop.data

import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.model.*
import com.github.javafaker.Faker
import java.time.LocalDate


class Data {

    companion object {
        const val KEY_WORD = "Ключевые слова: мастер-класс, помощь\n" +
                "Результаты поиска: 109 мероприятий"
    }

    private val faker = Faker()

    private val friendsList = listOf(
        User(
            "Дмитрий Валерьевич",
            LocalDate.of(1992, 3, 13),
            "Хирург",
            R.drawable.avatar_2,
            mutableListOf()
        ),
        User(
            "Евгений Александров",
            LocalDate.of(1991, 12, 12),
            "Терапевт",
            R.drawable.avatar_1,
            mutableListOf()
        ),
        User(
            "Виктор Кузницов",
            LocalDate.of(1988, 5, 7),
            "Плотник",
            R.drawable.avatar_2,
            mutableListOf()
        )
    )

    private val user: User = User(
        "Константинов Денис",
        LocalDate.of(1980, 2, 1),
        "Хирургия, трамвотология",
        R.drawable.image_man,
        friendsList,
        true
    )

    private val helps = listOf(
        Help("Дети", R.drawable.child),
        Help("Взрослые", R.drawable.adults),
        Help("Пожилые", R.drawable.elderly),
        Help("Животные", R.drawable.animals),
        Help("Мероприятия", R.drawable.events)
    )

    private val events = listOf(
        Event(name = faker.book().title()),
        Event(name = faker.book().title()),
        Event(name = faker.book().title()),
        Event(name = faker.book().title()),
        Event(name = faker.book().title())
    )

    private val categoryList = listOf(
        Category("kids", true),
        Category("adult", false),
        Category("elderly", false),
        Category("animals", false),
        Category("events", false)
    )

    fun getEvents() = events

    fun initUser() = user

    fun getDataHelp() = helps

    fun getCategory() = categoryList

    fun getResult(text: String): String {
        return KEY_WORD
    }

}
