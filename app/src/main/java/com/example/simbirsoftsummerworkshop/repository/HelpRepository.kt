package com.example.simbirsoftsummerworkshop.repository

import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.tasks.Task

typealias HelpListener = (List<Datas.HelpCategory>) -> Unit

interface HelpRepository {
    fun loadHelpList(): Task<List<Datas.HelpCategory>>

    fun addListener(listener: HelpListener)

    fun removeListener(listener: HelpListener)

    fun helpInit(help: List<Datas.HelpCategory>)

    fun isEmptyHelpCategory(): Boolean
}
