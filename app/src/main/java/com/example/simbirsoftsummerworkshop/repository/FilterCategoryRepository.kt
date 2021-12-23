package com.example.simbirsoftsummerworkshop.repository

import com.example.simbirsoftsummerworkshop.model.Datas

typealias CategoryListener = (List<Datas.FilterCategory>) -> Unit

interface FilterCategoryRepository : Repository {
    fun loadCategory(): List<Datas.FilterCategory>

    override fun addListener(listener: Listener) {
        installListener(listener)
    }

    override fun removeListener(listener: Listener) {
        deleteListener(listener)
    }

    fun installListener(listener: CategoryListener)

    fun deleteListener(listener: CategoryListener)
}