package com.example.simbirsoftsummerworkshop.model

import android.annotation.SuppressLint
import android.util.Log
import com.example.simbirsoftsummerworkshop.R
import com.github.javafaker.Faker

class DatasServise {
    companion object {
        private lateinit var instance: DatasServise
        fun newInstance() {
            instance = DatasServise()
        }
    }

    fun getInstance(): DatasServise = instance

    private val faker = Faker()

    @SuppressLint("NewApi")
    private val friendsList = listOf(
        Datas.User(
            "Дмитрий Валерьевич",
            org.threeten.bp.LocalDate.of(1992, 8, 16),
            "Хирург",
            R.drawable.avatar_2,
            mutableListOf()
        ),
        Datas.User(
            "Евгений Александров",
            org.threeten.bp.LocalDate.of(1991, 12, 12),
            "Терапевт",
            R.drawable.avatar_1,
            mutableListOf()
        ),
        Datas.User(
            "Виктор Кузницов",
            org.threeten.bp.LocalDate.of(1988, 5, 7),
            "Плотник",
            R.drawable.avatar,
            mutableListOf()
        ),
        Datas.User(
            "Дмитрий Валерьевич",
            org.threeten.bp.LocalDate.of(1992, 3, 13),
            "Хирург",
            R.drawable.avatar_2,
            mutableListOf()
        ),
        Datas.User(
            "Евгений Александров",
            org.threeten.bp.LocalDate.of(1991, 12, 12),
            "Терапевт",
            R.drawable.avatar_1,
            mutableListOf()
        ),
        Datas.User(
            "Виктор Кузницов",
            org.threeten.bp.LocalDate.of(1988, 5, 7),
            "Плотник",
            R.drawable.avatar,
            mutableListOf()
        )
    )

    @SuppressLint("NewApi")
    private var person: Datas.User = Datas.User(
        "Константинов Денис",
        org.threeten.bp.LocalDate.of(1980, 2, 1),
        "Хирургия, трамвотология",
        R.drawable.image_man,
        friendsList as MutableList<Datas.User>,
        true
    )

    private val helps = listOf(
        Datas.HelpCategory("Дети", R.drawable.child),
        Datas.HelpCategory("Взрослые", R.drawable.adults),
        Datas.HelpCategory("Пожилые", R.drawable.elderly),
        Datas.HelpCategory("Животные", R.drawable.animals),
        Datas.HelpCategory("Мероприятия", R.drawable.events)
    )

    private val events = listOf(
        Datas.Event(name = faker.book().title()),
        Datas.Event(name = faker.book().title()),
        Datas.Event(name = faker.book().title()),
        Datas.Event(name = faker.book().title()),
        Datas.Event(name = faker.book().title())
    )

    private var newsList = mutableListOf<Datas.News>()

    private val category = listOf(
        Datas.FilterCategory("Дети", false),
        Datas.FilterCategory("Взрослые", false),
        Datas.FilterCategory("Пожилые", false),
        Datas.FilterCategory("Животные", false),
        Datas.FilterCategory("Мероприятия", false)
    )

    fun getEvents() = events

    fun getPerson() = person

    fun getHelp() = helps

    fun getNews() = newsList

    fun getCategory() = category

    fun getResult(): String {
        return "Ключевые слова: мастер-класс, помощь\n" +
            "Результаты поиска: 109 мероприятий"
    }

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
        val helpList: MutableList<String> =
            mutableListOf()

        for (i in categoryList.indices) {
            helpList.add(categoryList[i].name)
        }

        return helpList
    }

    private fun filterNews(filteredNewsList: MutableList<String>): MutableList<Datas.News> {
        val resultList =
            DatasServise().getInstance().getNews().filter { it.helpCategory == filteredNewsList }
        return resultList as MutableList
    }

    fun saveNews(news: MutableList<Datas.News>): MutableList<Datas.News> {
        this.newsList = news
        Log.d("TEST", "news = $news")
        return news
    }
}
