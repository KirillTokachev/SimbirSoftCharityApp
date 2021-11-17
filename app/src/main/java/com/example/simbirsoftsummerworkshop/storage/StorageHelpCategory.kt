package com.example.simbirsoftsummerworkshop.storage

import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.repository.HelpListener
import com.example.simbirsoftsummerworkshop.repository.HelpRepository


class StorageHelpCategory : HelpRepository {
    companion object {
        private var helpCategory = listOf<Datas.HelpCategory>()
    }

    fun setHelpCategory(help: List<Datas.HelpCategory>) {
        helpCategory = help
    }

    private fun loadHelpCategory(): List<Datas.HelpCategory> = helpCategory

    private val listeners = mutableSetOf<HelpListener>()

    override fun loadHelpList(): List<Datas.HelpCategory> {
        return loadHelpCategory()
    }


    override fun addListener(listener: HelpListener) {
        listeners += listener
        listener(loadHelpCategory())
    }

    override fun removeListener(listener: HelpListener) {
        listeners -= listener
    }

}