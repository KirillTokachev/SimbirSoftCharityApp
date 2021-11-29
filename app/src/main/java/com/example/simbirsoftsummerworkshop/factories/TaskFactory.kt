package com.example.simbirsoftsummerworkshop.factories

import com.example.simbirsoftsummerworkshop.tasks.Task

typealias TaskBody<T> = () -> T

interface TaskFactory {
    fun <T> async(body: TaskBody<T>): Task<T>
}