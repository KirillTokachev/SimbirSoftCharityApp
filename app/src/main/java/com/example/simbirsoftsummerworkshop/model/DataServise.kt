package com.example.simbirsoftsummerworkshop.model

import android.util.Log
import com.example.simbirsoftsummerworkshop.R
import com.github.javafaker.Faker
import org.threeten.bp.LocalDate

private const val KEY_WORD =
    "Ключевые слова: мастер-класс, помощь\n" + "Результаты поиска: 109 мероприятий"

object DataServise {

    private val faker = Faker()

    private val friendsList: List<Datas.User> by lazy {
        listOf(
            Datas.User(
                name = "Дмитрий Валерьевич",
                dateOfBirth = LocalDate.of(1992, 8, 16),
                profession = "Хирург",
                avatar = R.drawable.avatar_2,
                friends = mutableListOf()
            ),
            Datas.User(
                name = "Евгений Александров",
                dateOfBirth = LocalDate.of(1991, 12, 12),
                profession = "Терапевт",
                avatar = R.drawable.avatar_1,
                friends = mutableListOf()
            ),
            Datas.User(
                name = "Виктор Кузницов",
                dateOfBirth = LocalDate.of(1988, 5, 7),
                profession = "Плотник",
                avatar = R.drawable.avatar,
                friends = mutableListOf()
            ),
            Datas.User(
                name = "Дмитрий Валерьевич",
                dateOfBirth = LocalDate.of(1992, 3, 13),
                profession = "Хирург",
                avatar = R.drawable.avatar_2,
                friends = mutableListOf()
            ),
            Datas.User(
                name = "Евгений Александров",
                dateOfBirth = LocalDate.of(1991, 12, 12),
                profession = "Терапевт",
                avatar = R.drawable.avatar_1,
                friends = mutableListOf()
            ),
            Datas.User(
                name = "Виктор Кузницов",
                dateOfBirth = LocalDate.of(1988, 5, 7),
                profession = "Плотник",
                avatar = R.drawable.avatar,
                friends = mutableListOf()
            )
        )
    }

    private val user: Datas.User by lazy {
        Datas.User(
            name = "Константинов Денис",
            dateOfBirth = LocalDate.of(1980, 2, 1),
            profession = "Хирургия, трамвотология",
            avatar = R.drawable.image_man,
            friends = friendsList,
            push = true
        )
    }

    private val events: List<Datas.Event> by lazy {
        listOf(
            Datas.Event(name = faker.book().title()),
            Datas.Event(name = faker.book().title()),
            Datas.Event(name = faker.book().title()),
            Datas.Event(name = faker.book().title()),
            Datas.Event(name = faker.book().title())
        )
    }

    private var newsList = listOf<Datas.News>()


    private val filterCategoriesList = listOf(
        Datas.FilterCategory("Дети", false),
        Datas.FilterCategory("Взрослые", false),
        Datas.FilterCategory("Пожилые", false),
        Datas.FilterCategory("Животные", false),
        Datas.FilterCategory("Мероприятия", false)
    )

    fun loadCategories(): List<Datas.FilterCategory> {
        return filterCategoriesList
    }

    fun saveNews(news: List<Datas.News>) {
        newsList = news
    }

    fun loadNews(): List<Datas.News> {
        return newsList
    }

    fun loadEvent() = events

    fun loadUser() = user

    fun loadResult() = KEY_WORD

    fun sortCategory(categoryList: MutableList<Datas.FilterCategory>): MutableList<Datas.FilterCategory> {
        val sortCategoryList = categoryList.filter { it.push } as MutableList
        Log.d("TEST", "size sortCategoryList: ${sortCategoryList.size}")
        return sortCategoryList
    }

    fun filterList(categoryList: MutableList<Datas.FilterCategory>): MutableList<Datas.News> {
        val newCategoryList = sortCategory(categoryList)
        val sortStringCategory = filterListToStringList(newCategoryList)
        return filterNews(sortStringCategory)
    }

    private fun filterListToStringList(categoryList: MutableList<Datas.FilterCategory>): MutableList<String> {
        val helpList: MutableList<String> = mutableListOf()

        categoryList.map { helpList.add(it.name) }

        return helpList
    }

    private fun filterNews(filteredNewsList: MutableList<String>): MutableList<Datas.News> {
        val resultList =
            newsList.filter { it.helpCategory == filteredNewsList }
        return resultList as MutableList
    }

}
