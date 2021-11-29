package com.example.simbirsoftsummerworkshop.view.help

import com.example.simbirsoftsummerworkshop.dispatchers.Dispatcher
import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.repository.HelpListener
import com.example.simbirsoftsummerworkshop.repository.HelpRepository
import com.example.simbirsoftsummerworkshop.tasks.PendingResult
import com.example.simbirsoftsummerworkshop.tasks.SuccessResult
import com.example.simbirsoftsummerworkshop.view.fragments.BaseViewModel
import com.example.simbirsoftsummerworkshop.view.fragments.LiveResult
import com.example.simbirsoftsummerworkshop.view.fragments.MutableLiveResult


class HelpFragmentViewModel(
    private val helpRepository: HelpRepository,
    dispatcher: Dispatcher,
) : BaseViewModel(dispatcher) {

    private val _currentHelp = MutableLiveResult<List<Datas.HelpCategory>>(PendingResult())
    val currentHelp: LiveResult<List<Datas.HelpCategory>> = _currentHelp

    private val helpListener: HelpListener = {
        _currentHelp.postValue(SuccessResult(it))
    }

    init {
        helpRepository.addListener(helpListener)
        load()
    }

    override fun onCleared() {
        super.onCleared()
        helpRepository.removeListener(helpListener)
    }

    private fun load() {
        helpRepository.loadHelpList().into(_currentHelp)
    }

    fun saveHelpCategory(help: List<Datas.HelpCategory>) {
        helpRepository.helpInit(help)
    }
}