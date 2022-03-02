package com.example.simbirsoftsummerworkshop

import android.app.Application
import com.example.simbirsoftsummerworkshop.dispatchers.MainThreadDispatcher
import com.example.simbirsoftsummerworkshop.dispatchers.ThreadUtils
import com.example.simbirsoftsummerworkshop.factories.ExecutorServiceTaskFactory
import com.example.simbirsoftsummerworkshop.network.ServerApi
import com.example.simbirsoftsummerworkshop.storage.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.Executors

class App : Application() {
    private val taskFactory = ExecutorServiceTaskFactory(Executors.newCachedThreadPool())
    private val threadUtils = ThreadUtils.Default()
    lateinit var serverApi: ServerApi
    val dispatcher = MainThreadDispatcher()
    val storageHelpCategory = StorageHelpCategory(taskFactory, threadUtils)
    val storageNews = StorageNews(taskFactory, threadUtils)
    val storageUser = StorageUser()
    val storageEvent = StorageEvent()

    override fun onCreate() {
        super.onCreate()

        configureRetrofit()
    }

    private fun configureRetrofit() {
        val httpLoginInterceptor = HttpLoggingInterceptor()
        httpLoginInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoginInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://fakeserver.getsandbox.com:443")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        serverApi = retrofit.create(ServerApi::class.java)
    }
}
