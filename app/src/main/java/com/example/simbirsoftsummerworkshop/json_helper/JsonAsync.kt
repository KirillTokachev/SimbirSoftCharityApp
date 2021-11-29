package com.example.simbirsoftsummerworkshop.json_helper

import android.content.Context
import android.os.AsyncTask
import com.example.simbirsoftsummerworkshop.adapters.JsonAdapter
import com.example.simbirsoftsummerworkshop.dispatchers.ThreadUtils
import com.example.simbirsoftsummerworkshop.factories.TaskFactory
import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.storage.StorageNews

class JsonAsync(
    var context: Context,
    var callback: JsonCallBack<List<Datas.News>>?,
    private val taskFactory: TaskFactory,
    private val threadUtils: ThreadUtils
) :
    AsyncTask<Void, Int, List<Datas.News>>() {
    private var exception: Exception? = null

    override fun doInBackground(vararg params: Void?): List<Datas.News> {
        lateinit var events: List<Datas.News>
        try {
            events = JsonAdapter(context).getNews()
        } catch (e: Exception) {
            exception = e
        }
        return events
    }

    override fun onPostExecute(result: List<Datas.News>?) {
        StorageNews(taskFactory, threadUtils).saveNews(result!!)
        if (callback != null) {
            if (exception == null) {
                callback!!.onSuccess(result)
            } else callback!!.onFailure(exception!!)
        }
    }

}