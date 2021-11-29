package com.example.simbirsoftsummerworkshop.dispatchers

interface Dispatcher {
    fun dispatch(block: () -> Unit)
}