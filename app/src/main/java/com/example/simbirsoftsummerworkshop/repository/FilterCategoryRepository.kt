package com.example.simbirsoftsummerworkshop.repository

import com.example.simbirsoftsummerworkshop.model.Datas

typealias CategoryListener = (List<Datas.FilterCategory>) -> Unit

interface FilterCategoryRepository {

    fun loadCategory(): List<Datas.FilterCategory>

    fun addListener(listener: CategoryListener)

    fun removeListener(listener: CategoryListener)

}