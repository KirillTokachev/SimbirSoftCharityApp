package com.example.simbirsoftsummerworkshop.repository

import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.tasks.Task

typealias HelpListener = (List<Datas.HelpCategory>) -> Unit

interface HelpRepository : Repository {
    fun loadHelpList(): Task<List<Datas.HelpCategory>>

    override fun addListener(listener: Listener) {
        installListener(listener)
    }

    override fun removeListener(listener: Listener) {
        deleteListener(listener)
    }

    fun installListener(listener: HelpListener)

    fun deleteListener(listener: HelpListener)

    fun helpInit(help: List<Datas.HelpCategory>)
}