package com.example.simbirsoftsummerworkshop.repository

import com.example.simbirsoftsummerworkshop.model.Datas

typealias EventListener = (List<Datas.Event>) -> Unit

interface EventRepository : Repository {
    fun loadEvent(): List<Datas.Event>

    override fun addListener(listener: Listener) {
        installListener(listener)
    }

    override fun removeListener(listener: Listener) {
        deleteListener(listener)
    }

    fun installListener(listener: EventListener)

    fun deleteListener(listener: EventListener)
}