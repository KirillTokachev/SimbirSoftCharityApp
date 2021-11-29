package com.example.simbirsoftsummerworkshop.tasks

import com.example.simbirsoftsummerworkshop.dispatchers.Dispatcher

typealias TaskListener<T> = (FinalResult<T>) -> Unit

class CancelException(
    originalException: Exception? = null
) : Exception(originalException)

interface Task<T> {
    fun enqueue(dispatcher: Dispatcher, listener: TaskListener<T>)

    fun cancel()

    fun await(): T
}