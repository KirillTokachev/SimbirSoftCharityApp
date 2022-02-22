package com.example.simbirsoftsummerworkshop.storage

import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.repository.EventListener
import com.example.simbirsoftsummerworkshop.repository.EventRepository

class StorageEvent : EventRepository {

    private var _events = listOf<Datas.Event>()
    private var _searchEvent = listOf<Datas.Event>()

    override fun getSearchResultTitle(): String {
        return "Ключевые слова: мастер-класс, помощь\nРезультаты поиска: ${_events.size} мероприятий"
    }

    override fun clearEvents() {
        _events.toMutableList().clear()
        _searchEvent.toMutableList().clear()
    }

    private val listeners = mutableSetOf<EventListener>()

    override fun loadEvent(): List<Datas.Event> {
        return _events
    }

    override fun loadSearchEvent(): List<Datas.Event> {
        return _searchEvent
    }

    override fun saveSearchEvent(events: List<Datas.Event>) {
        _searchEvent = events
    }

    override fun saveEvent(events: List<Datas.Event>) {
        _events = events
    }

    override fun addListener(listener: EventListener) {
        listeners += listener
        listener(_events)
    }
}
