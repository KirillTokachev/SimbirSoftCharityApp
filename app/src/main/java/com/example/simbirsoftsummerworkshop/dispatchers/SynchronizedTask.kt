package com.example.simbirsoftsummerworkshop.dispatchers

import com.example.simbirsoftsummerworkshop.tasks.CancelException
import com.example.simbirsoftsummerworkshop.tasks.Task
import com.example.simbirsoftsummerworkshop.tasks.TaskListener
import java.util.concurrent.atomic.AtomicBoolean

class SynchronizedTask<T>(
    private val task: Task<T>
) : Task<T> {
    @Volatile
    private var cancelled = false

    @Volatile
    private var executed = false
    private var listenerCalled = AtomicBoolean(false)

    override fun enqueue(dispatcher: Dispatcher, listener: TaskListener<T>) = synchronized(this) {
        if (cancelled) return
        if (executed) throw IllegalStateException("Task has been executed")
        val finalListener: TaskListener<T> = { result ->
            if (listenerCalled.compareAndSet(false, true)) {
                if (!cancelled) listener(result)
            }
        }
        task.enqueue(dispatcher, finalListener)
    }

    override fun cancel() = synchronized(this) {
        if (listenerCalled.compareAndSet(false, true)) {
            if (cancelled) return
            cancelled = true
            task.cancel()
        }
    }

    override fun await(): T {
        synchronized(this) {
            if (cancelled) throw CancelException()
            if (executed) throw IllegalStateException("Task has been executed")
            executed = true
        }
        return task.await()
    }
}
