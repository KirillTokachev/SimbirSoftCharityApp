package com.example.simbirsoftsummerworkshop.storage

import com.example.simbirsoftsummerworkshop.dispatchers.ThreadUtils
import com.example.simbirsoftsummerworkshop.factories.TaskFactory
import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.repository.HelpListener
import com.example.simbirsoftsummerworkshop.repository.HelpRepository
import com.example.simbirsoftsummerworkshop.repository.Listener
import com.example.simbirsoftsummerworkshop.tasks.Task

class StorageHelpCategory(
    private val taskFactory: TaskFactory,
    private val threadUtils: ThreadUtils
) : HelpRepository {
    companion object {
        private var helpCategory = listOf<Datas.HelpCategory>()
    }

    private fun saveHelpCategory(help: List<Datas.HelpCategory>) {
        helpCategory = help
    }

    private val listeners = mutableSetOf<HelpListener>()

    override fun loadHelpList(): Task<List<Datas.HelpCategory>> = taskFactory.async {
        threadUtils.sleep(1000)
        return@async helpCategory
    }


    override fun installListener(listener: HelpListener) {
        listeners += listener
    }

    override fun deleteListener(listener: HelpListener) {
        listeners -= listener
    }

    override fun helpInit(help: List<Datas.HelpCategory>) {
        return saveHelpCategory(help)
    }

}