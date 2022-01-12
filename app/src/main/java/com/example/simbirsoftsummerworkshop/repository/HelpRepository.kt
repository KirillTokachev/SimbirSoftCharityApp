package com.example.simbirsoftsummerworkshop.repository

import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.tasks.Task

typealias HelpListener = (List<Datas.HelpCategory>) -> Unit

interface HelpRepository{
    fun loadHelpList(): Task<List<Datas.HelpCategory>>

    fun installListener(listener: HelpListener)

    fun deleteListener(listener: HelpListener)

    fun saveData(help: List<Datas.HelpCategory>)
}