package com.example.simbirsoftsummerworkshop.factories

import com.example.simbirsoftsummerworkshop.dispatchers.AbstractTask
import com.example.simbirsoftsummerworkshop.dispatchers.SynchronizedTask
import com.example.simbirsoftsummerworkshop.tasks.*

class ThreadTaskFactory : TaskFactory {
    override fun <T> async(body: TaskBody<T>): Task<T> {
        return SynchronizedTask(ThreadTask(body))
    }

    private class ThreadTask<T>(
        private val body: TaskBody<T>
    ) : AbstractTask<T>() {
        private var thread: Thread? = null

        override fun doEnqueue(listener: TaskListener<T>) {
            thread = Thread {
                executeBody(body, listener)
            }
            thread?.start()
        }

        override fun doCancel() {
            thread?.interrupt()
        }
    }
}
