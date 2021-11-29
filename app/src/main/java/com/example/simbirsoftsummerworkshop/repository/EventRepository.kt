package com.example.simbirsoftsummerworkshop.repository

import com.example.simbirsoftsummerworkshop.model.Datas

typealias EventListener = (List<Datas.Event>) -> Unit

interface EventRepository : Repository {
    fun loadEvent(): List<Datas.Event>

    fun addListener(listener: EventListener)

    fun removeListener(listener: EventListener)
}