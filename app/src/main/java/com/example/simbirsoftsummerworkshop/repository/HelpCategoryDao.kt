package com.example.simbirsoftsummerworkshop.repository

import androidx.room.*
import com.example.simbirsoftsummerworkshop.model.Datas
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single


@Dao
interface HelpCategoryDao {

    @Query("SELECT * FROM help_category")
    fun loadHelpList(): Single<List<Datas.HelpCategory>>

    @Insert(entity = Datas.HelpCategory::class, onConflict = OnConflictStrategy.REPLACE)
    fun saveHelps(help: List<Datas.HelpCategory>): Completable

}
