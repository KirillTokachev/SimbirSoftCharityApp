package com.example.simbirsoftsummerworkshop

import android.app.Application
import com.example.simbirsoftsummerworkshop.dispatchers.MainThreadDispatcher
import com.example.simbirsoftsummerworkshop.dispatchers.ThreadUtils
import com.example.simbirsoftsummerworkshop.factories.ExecutorServiceTaskFactory
import com.example.simbirsoftsummerworkshop.factories.ThreadTaskFactory
import com.example.simbirsoftsummerworkshop.storage.*
import java.util.concurrent.Executors


class App : Application() {
    private val taskFactory = ExecutorServiceTaskFactory(Executors.newCachedThreadPool())
    private val threadUtils = ThreadUtils.Default()
    val dispatcher = MainThreadDispatcher()
    val storageHelpCategory = StorageHelpCategory(taskFactory, threadUtils)
    val storageNews = StorageNews(taskFactory, threadUtils)
    val storageUser = StorageUser()
}