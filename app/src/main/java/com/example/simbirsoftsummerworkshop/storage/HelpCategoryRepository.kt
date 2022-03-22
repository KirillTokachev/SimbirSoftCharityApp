package com.example.simbirsoftsummerworkshop.storage

import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.repository.HelpCategoryDao
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class HelpCategoryRepository(
    private val helpCategoryDao: HelpCategoryDao
) {
    fun loadHelpList(): Single<List<Datas.HelpCategory>> = helpCategoryDao.loadHelpList()

    fun saveHelps(help: List<Datas.HelpCategory>): Completable =
        helpCategoryDao.saveHelps(help)

}
