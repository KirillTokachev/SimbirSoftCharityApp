package com.example.simbirsoftsummerworkshop.dispatchers

import android.os.Handler
import android.os.Looper

class MainThreadDispatcher : Dispatcher {
    private val handler = Handler(Looper.getMainLooper())

    override fun dispatch(block: () -> Unit) {
        when (Looper.getMainLooper().thread.id) {
            Thread.currentThread().id -> block()
            else -> handler.post(block)
        }
    }
}
