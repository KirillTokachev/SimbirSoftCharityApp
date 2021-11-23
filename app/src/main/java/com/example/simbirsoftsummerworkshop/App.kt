package com.example.simbirsoftsummerworkshop

import android.app.Application
import com.example.simbirsoftsummerworkshop.dispatchers.MainThreadDispatcher
import com.example.simbirsoftsummerworkshop.dispatchers.ThreadUtils
import com.example.simbirsoftsummerworkshop.factories.ThreadTaskFactory
import com.example.simbirsoftsummerworkshop.storage.*


class App : Application() {

    private val taskFactory = ThreadTaskFactory()
    private val threadUtils = ThreadUtils.Default()
    val dispatcher = MainThreadDispatcher()
    val storageHelpCategory = StorageHelpCategory(taskFactory, threadUtils)
    val storageNews = StorageNews(taskFactory, threadUtils)
    val storageUser = StorageUser()
    val storageEvent = StorageEvent()
    val storageCategory = StorageFilterCategory()

    override fun onCreate() {
        super.onCreate()
        dispatcher
        threadUtils
        taskFactory
        storageHelpCategory
        storageNews
        storageUser
        storageEvent
        storageCategory
    }

}