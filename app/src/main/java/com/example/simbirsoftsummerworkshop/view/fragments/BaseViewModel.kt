package com.example.simbirsoftsummerworkshop.view.fragments

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.simbirsoftsummerworkshop.App
import com.example.simbirsoftsummerworkshop.dispatchers.Dispatcher
import com.example.simbirsoftsummerworkshop.tasks.PendingResult
import com.example.simbirsoftsummerworkshop.tasks.Result
import com.example.simbirsoftsummerworkshop.tasks.Task
import com.example.simbirsoftsummerworkshop.tasks.TaskListener

typealias LiveResult<T> = LiveData<Result<T>>
typealias MutableLiveResult<T> = MutableLiveData<Result<T>>

open class BaseViewModel(
    application: App,
    private val dispatcher: Dispatcher
) : AndroidViewModel(application) {
    private val tasks = mutableSetOf<Task<*>>()

    override fun onCleared() {
        super.onCleared()
        tasks.forEach { it.cancel() }
        tasks.clear()
    }

    private fun <T> Task<T>.safeEnqueue(listener: TaskListener<T>? = null) {
        tasks.add(this)
        this.enqueue(dispatcher) {
            tasks.remove(this)
            listener?.invoke(it)
        }
    }

    fun <T> Task<T>.into(liveResult: MutableLiveResult<T>) {
        liveResult.value = PendingResult()
        this.safeEnqueue {
            liveResult.value = it
        }
    }
}
