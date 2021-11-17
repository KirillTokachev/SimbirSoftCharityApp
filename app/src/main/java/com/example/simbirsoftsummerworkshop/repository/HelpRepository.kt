package com.example.simbirsoftsummerworkshop.repository

import com.example.simbirsoftsummerworkshop.model.Datas

typealias HelpListener = (List<Datas.HelpCategory>) -> Unit

interface HelpRepository {

    fun loadHelpList(): List<Datas.HelpCategory>

    fun addListener(listener: HelpListener)

    fun removeListener(listener: HelpListener)

}