package com.example.simbirsoftsummerworkshop.storage

import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.repository.EventListener
import com.example.simbirsoftsummerworkshop.repository.EventRepository
import com.github.javafaker.Faker

private const val KEY_WORD =
    "Ключевые слова: мастер-класс, помощь\n" + "Результаты поиска: 109 мероприятий"

class StorageEvent : EventRepository {
    companion object {
        private val faker = Faker()

        private val events: List<Datas.Event> by lazy {
            listOf(
                Datas.Event(name = faker.book().title()),
                Datas.Event(name = faker.book().title()),
                Datas.Event(name = faker.book().title()),
                Datas.Event(name = faker.book().title()),
                Datas.Event(name = faker.book().title())
            )
        }
    }

    fun getResult(): String = KEY_WORD

    private fun loadEvents(): List<Datas.Event> = events

    private val listeners = mutableSetOf<EventListener>()

    override fun loadEvent(): List<Datas.Event> {
        return loadEvents()
    }

    override fun addListener(listener: EventListener) {
        listeners += listener
        listener(loadEvents())
    }

    override fun removeListener(listener: EventListener) {
        listeners -= listener
    }
}