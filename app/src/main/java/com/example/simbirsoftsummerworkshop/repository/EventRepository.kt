package com.example.simbirsoftsummerworkshop.repository

import com.example.simbirsoftsummerworkshop.model.Datas

typealias EventListener = (List<Datas.Event>) -> Unit

interface EventRepository {
    fun loadEvent(): List<Datas.Event>

    fun loadSearchEvent(): List<Datas.Event>

    fun saveSearchEvent(events: List<Datas.Event>)

    fun addListener(listener: EventListener)

    fun saveEvent(events: List<Datas.Event>)

    fun getSearchResultTitle(): String

    fun clearEvents()

}