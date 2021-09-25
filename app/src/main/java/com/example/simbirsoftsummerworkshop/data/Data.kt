package com.example.simbirsoftsummerworkshop.data

import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.model.*
import com.github.javafaker.Faker
import java.time.LocalDate

class Data {

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

    private val person: User = User(
        "Константинов Денис",
        LocalDate.of(1980, 2, 1),
        "Хирургия, трамвотология",
        R.drawable.image_man,
        friendsList as MutableList<User>,
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

    private val newsList = listOf(
        News("Спонсоры отремонтируют школу-интернат",
            "Дубовская школа-интернат для детей с ограниченными возможностями здоровья стала первой в области …",
            R.drawable.news_1,
            org.joda.time.LocalDate(), "kids", 0),
        News("Конкурс по вокальному пению в детском доме №6",
            "Дубовская школа-интернат для детей с ограниченными возможностями здоровья стала первой в области …",
            R.drawable.news_2,
            org.joda.time.LocalDate(), "kids", 1)
    )

    private val categoryList = mutableListOf(
        Category("kids", true),
        Category("adult", false),
        Category("elderly", false),
        Category("animals", false),
        Category("events", false)
    )

    fun getEvents(): List<Event> {
        return events
    }

    fun getPerson(): User {
        return person
    }

    fun getDataHelp(): List<Help> {
        return helps
    }

    fun getNews(): List<News> {
        return newsList
    }

    fun getCategory() : List<Category> {
        return categoryList
    }

    fun getResult(text: String): String {
        return "Ключевые слова: мастер-класс, помощь\n" +
            "Результаты поиска: 109 мероприятий"
    }

}
