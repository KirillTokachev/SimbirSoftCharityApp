package com.example.simbirsoftsummerworkshop.view.help

import com.example.simbirsoftsummerworkshop.App
import com.example.simbirsoftsummerworkshop.adapters.JsonAdapter
import com.example.simbirsoftsummerworkshop.dispatchers.Dispatcher
import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.network.ServerApi
import com.example.simbirsoftsummerworkshop.repository.HelpListener
import com.example.simbirsoftsummerworkshop.repository.HelpRepository
import com.example.simbirsoftsummerworkshop.tasks.PendingResult
import com.example.simbirsoftsummerworkshop.tasks.SuccessResult
import com.example.simbirsoftsummerworkshop.view.fragments.BaseViewModel
import com.example.simbirsoftsummerworkshop.view.fragments.LiveResult
import com.example.simbirsoftsummerworkshop.view.fragments.MutableLiveResult
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class HelpFragmentViewModel(
    private val application: App,
    private val helpRepository: HelpRepository,
    dispatcher: Dispatcher,
) : BaseViewModel(application, dispatcher) {

    private val _currentHelp = MutableLiveResult<List<Datas.HelpCategory>>(PendingResult())
    val currentHelp: LiveResult<List<Datas.HelpCategory>> = _currentHelp

    private val compositeDisposable = CompositeDisposable()

    private val helpListener: HelpListener = {
        _currentHelp.postValue(SuccessResult(it))
    }

    init {
        helpRepository.addListener(helpListener)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
        helpRepository.removeListener(helpListener)
    }

    fun loadNews() {
        helpRepository.loadHelpList().into(_currentHelp)
    }

    fun saveHelpCategory(help: List<Datas.HelpCategory>) {
        helpRepository.helpInit(help)
    }

    fun isEmptyHelpCategory(): Boolean {
        return helpRepository.isEmptyHelpCategory()
    }

    fun fetchHelpCategory(serverApi: ServerApi) {
        compositeDisposable.add(
            serverApi.getHelpCategoryList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    saveHelpCategory(it)
                }, {
                    saveHelpCategory(JsonAdapter(application.applicationContext).getCategory())
                })
        )
    }
}
