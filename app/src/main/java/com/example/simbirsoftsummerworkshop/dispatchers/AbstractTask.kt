package com.example.simbirsoftsummerworkshop.dispatchers

import com.example.simbirsoftsummerworkshop.delegates.Await
import com.example.simbirsoftsummerworkshop.factories.TaskBody
import com.example.simbirsoftsummerworkshop.tasks.*

abstract class AbstractTask<T> : Task<T> {
    private var finalResult by Await<FinalResult<T>>()

    final override fun enqueue(dispatcher: Dispatcher, listener: TaskListener<T>) {
        val wrapperListener: TaskListener<T> = {
            finalResult = it
            dispatcher.dispatch {
                listener(finalResult)
            }
        }
        doEnqueue(wrapperListener)
    }

    final override fun cancel() {
        finalResult = FailureResult(CancelException())
        doCancel()
    }

    final override fun await(): T {
        val wrapperListener: TaskListener<T> = {
            finalResult = it
        }
        doEnqueue(wrapperListener)
        try {
            return when (val result = finalResult) {
                is FailureResult -> throw result.error
                is SuccessResult -> return result.data
                else -> {
                    throw IllegalStateException()
                }
            }
        } catch (e: Exception) {
            if (e is InterruptedException) {
                cancel()
                throw CancelException(e)
            } else {
                throw e
            }
        }
    }

    fun executeBody(taskBody: TaskBody<T>, listener: TaskListener<T>) {
        try {
            val data = taskBody()
            listener(SuccessResult(data))
        } catch (e: Exception) {
            listener(FailureResult(e))
        }
    }

    abstract fun doEnqueue(listener: TaskListener<T>)

    abstract fun doCancel()
}
