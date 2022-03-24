package com.example.simbirsoftsummerworkshop.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.tasks.Task
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface NewsDao {

    @Query("SELECT * FROM news")
    fun loadNews(): Single<List<Datas.News>>

    @Insert(entity = Datas.News::class, onConflict = OnConflictStrategy.IGNORE)
    fun saveNews(news: List<Datas.News>): Completable
}
