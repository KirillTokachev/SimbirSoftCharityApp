package com.example.simbirsoftsummerworkshop.view.help

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.repository.HelpListener
import com.example.simbirsoftsummerworkshop.repository.HelpRepository
import com.example.simbirsoftsummerworkshop.tasks.PendingResult
import com.example.simbirsoftsummerworkshop.tasks.Result
import com.example.simbirsoftsummerworkshop.tasks.SuccessResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

typealias LiveResult<T> = LiveData<Result<T>>
typealias MutableLiveResult<T> = MutableLiveData<Result<T>>

class HelpFragmentViewModel(
    private val helpRepository: HelpRepository
) : ViewModel() {

    private val _currentHelp = MutableLiveResult<List<Datas.HelpCategory>>(PendingResult())
    val currentHelp: LiveResult<List<Datas.HelpCategory>> = _currentHelp

    private val helpListener: HelpListener = {
        _currentHelp.postValue(SuccessResult(it))
    }

    init {
        viewModelScope.launch {
            delay(2000)
            helpRepository.addListener(helpListener)
        }
    }

    override fun onCleared() {
        super.onCleared()
        helpRepository.removeListener(helpListener)
    }
}