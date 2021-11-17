package com.example.simbirsoftsummerworkshop

import android.app.Application
import com.example.simbirsoftsummerworkshop.storage.*


class App : Application() {

    val storageHelpCategory = StorageHelpCategory()
    val storageNews = StorageNews()
    val storageUser = StorageUser()
    val storageEvent = StorageEvent()
    val storageCategory = StorageFilterCategory()

    override fun onCreate() {
        super.onCreate()
        storageHelpCategory
        storageNews
        storageUser
        storageEvent
        storageCategory
    }

}