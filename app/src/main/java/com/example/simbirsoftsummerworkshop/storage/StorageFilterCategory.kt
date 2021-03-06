package com.example.simbirsoftsummerworkshop.storage

import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.repository.CategoryListener
import com.example.simbirsoftsummerworkshop.repository.FilterCategoryRepository

class StorageFilterCategory : FilterCategoryRepository {
    companion object {
        private val filterCategoriesList: List<Datas.FilterCategory> by lazy {
            listOf(
                Datas.FilterCategory("Дети", false),
                Datas.FilterCategory("Взрослые", false),
                Datas.FilterCategory("Пожилые", false),
                Datas.FilterCategory("Животные", false),
                Datas.FilterCategory("Мероприятия", false)
            )
        }
    }

    private val listeners = mutableSetOf<CategoryListener>()

    override fun loadCategory(): List<Datas.FilterCategory> {
        return filterCategoriesList
    }

    override fun addListener(listener: CategoryListener) {
        listeners += listener
        listener(filterCategoriesList)
    }

    override fun removeListener(listener: CategoryListener) {
        listeners -= listener
    }
}
