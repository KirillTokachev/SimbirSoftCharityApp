package com.example.simbirsoftsummerworkshop.storage

import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.repository.EventListener
import com.example.simbirsoftsummerworkshop.repository.EventRepository
import com.github.javafaker.Faker

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

        private val KEY_WORD =
            "Ключевые слова: мастер-класс, помощь\n" + "Результаты поиска: ${events.size} мероприятий"
    }

    fun getSearchResultTitle() = KEY_WORD

    private val listeners = mutableSetOf<EventListener>()

    override fun loadEvent(): List<Datas.Event> {
        return events
    }

    override fun installListener(listener: EventListener) {
        listeners += listener
        listener(events)
    }

    override fun deleteListener(listener: EventListener) {
        listeners -= listener
    }

}