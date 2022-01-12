package com.example.simbirsoftsummerworkshop.repository

import com.example.simbirsoftsummerworkshop.model.Datas

typealias EventListener = (List<Datas.Event>) -> Unit

interface EventRepository {
    fun loadEvent(): List<Datas.Event>

    fun installListener(listener: EventListener)

    fun deleteListener(listener: EventListener)
}