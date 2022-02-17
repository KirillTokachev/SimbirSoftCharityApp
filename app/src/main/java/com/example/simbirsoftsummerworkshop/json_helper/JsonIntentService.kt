package com.example.simbirsoftsummerworkshop.json_helper

import android.app.IntentService
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.example.simbirsoftsummerworkshop.adapters.JsonAdapter
import com.example.simbirsoftsummerworkshop.adapters.RecyclerAdapter
import com.example.simbirsoftsummerworkshop.dispatchers.ThreadUtils
import com.example.simbirsoftsummerworkshop.factories.TaskFactory
import com.example.simbirsoftsummerworkshop.storage.StorageNews

class JsonIntentService(
    private val taskFactory: TaskFactory,
    private val threadUtils: ThreadUtils,
    private val context: Context
) : IntentService("BackgroundIntentService") {
    companion object {
        const val ACTION = "Load_news_from_json_file"
        const val EXTRA_KEY_OUT = "Extra_Out"
        const val finished = "finished"
    }

    private val adapter = RecyclerAdapter(JsonAdapter(context).getNews())

    fun start(
        context: Context
    ) {
        val intentService = Intent(context, JsonIntentService::class.java)
        context.startService(intentService)
    }

    override fun onHandleIntent(intent: Intent?) {
        Thread.sleep(5000)
        StorageNews(taskFactory, threadUtils).saveNews(JsonAdapter(this).getNews())
        val response = Intent()
        response.action = ACTION
        response.addCategory(Intent.CATEGORY_DEFAULT)
        response.putExtra(EXTRA_KEY_OUT, finished)
        sendBroadcast(response)
    }

    inner class MyBroadcastReceiver(
        private val recyclerView: RecyclerView,
        private val progressBar: ProgressBar
    ) : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            progressBar.visibility = View.GONE
            recyclerView.adapter = adapter
        }
    }
}
