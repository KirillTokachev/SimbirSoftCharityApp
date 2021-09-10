package com.example.simbirsoftsummerworkshop.data

import android.content.res.Resources
import android.graphics.BitmapFactory
import com.example.simbirsoftsummerworkshop.R
import com.github.javafaker.Faker
import java.time.LocalDate

class Data(resource: Resources) {
    private val faker = Faker()

    private val friendsList = listOf(
        User(
            "Дмитрий Валерьевич",
            LocalDate.of(1992, 3, 13),
            "Хирург",
            BitmapFactory.decodeResource(resource, R.drawable.avatar),
            mutableListOf()
        ),
        User(
            "Евгений Александров",
            LocalDate.of(1991, 12, 12),
            "Терапевт",
            BitmapFactory.decodeResource(resource, R.drawable.avatar_1),
            mutableListOf()
        ),
        User(
            "Виктор Кузницов",
            LocalDate.of(1988, 5, 7),
            "Плотник",
            BitmapFactory.decodeResource(resource, R.drawable.avatar_2),
            mutableListOf()
        )
    )

    private val person: User = User(
        "Константинов Денис",
        LocalDate.of(1980, 2, 1),
        "Хирургия, трамвотология",
        BitmapFactory.decodeResource(resource, R.drawable.image_man),
        friendsList as MutableList<User>,
        true
    )

    private val helps = listOf(
        Help("Дети", BitmapFactory.decodeResource(resource, R.drawable.child)),
        Help("Взрослые", BitmapFactory.decodeResource(resource, R.drawable.adults)),
        Help("Пожилые", BitmapFactory.decodeResource(resource, R.drawable.elderly)),
        Help("Животные", BitmapFactory.decodeResource(resource, R.drawable.animals)),
        Help("Мероприятия", BitmapFactory.decodeResource(resource, R.drawable.events))
    )

    private val events = listOf(
        Event(name = faker.book().title()),
        Event(name = faker.book().title()),
        Event(name = faker.book().title()),
        Event(name = faker.book().title()),
        Event(name = faker.book().title())
    )

    private val nko = listOf(
        CharitableFoundation(name = faker.company().industry()),
        CharitableFoundation(name = faker.company().industry()),
        CharitableFoundation(name = faker.company().industry()),
        CharitableFoundation(name = faker.company().industry()),
        CharitableFoundation(name = faker.company().industry())
    )

    fun getNko(): List<CharitableFoundation> {
        return nko
    }

    fun getEvents(): List<Event> {
        return events
    }

    fun getPerson(): User {
        return person
    }

    fun getDataHelp(): List<Help> {
        return helps
    }

    fun getResult(text: String): String {
        return "Ключевые слова: мастер-класс, помощь\n" +
            "Результаты поиска: 109 мероприятий"
    }
}
