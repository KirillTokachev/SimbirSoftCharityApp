package com.example.simbirsoftsummerworkshop.view.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.repository.EventRepository

class SearchViewModel(
    private val repository: EventRepository,
) : ViewModel() {

    private val _events = MutableLiveData<List<Datas.Event>>()
    val events: LiveData<List<Datas.Event>> = _events

    fun saveEvents(events: List<Datas.Event>) {
        _events.value = events
        repository.saveEvent(events)
    }

    fun clearEvents() {
        repository.clearEvents()
    }

    fun loadEvents(): List<Datas.Event> {
        return repository.loadEvent()
    }

    fun saveSearchEvent(events: List<Datas.Event>) {
        repository.saveSearchEvent(events)
    }

    fun loadSearchEvent(): List<Datas.Event> {
        return repository.loadSearchEvent()
    }

    fun loadResultSearchCount(): String {
        return repository.getSearchResultTitle()
    }
}
