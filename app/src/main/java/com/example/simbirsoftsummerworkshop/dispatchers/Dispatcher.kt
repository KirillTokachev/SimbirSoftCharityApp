package com.example.simbirsoftsummerworkshop.dispatchers

fun interface Dispatcher {
    fun dispatch(block: () -> Unit)
}