package com.example.simbirsoftsummerworkshop.repository

typealias Listener = (List<Any>) -> Unit

interface Repository {
    fun addListener(listener: Listener)

    fun removeListener(listener: Listener)
}