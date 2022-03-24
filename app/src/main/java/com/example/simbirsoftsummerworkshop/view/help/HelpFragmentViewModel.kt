package com.example.simbirsoftsummerworkshop.view.help

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.simbirsoftsummerworkshop.App
import com.example.simbirsoftsummerworkshop.adapters.JsonAdapter
import com.example.simbirsoftsummerworkshop.data_base.AppDataBase
import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.network.ServerApi
import com.example.simbirsoftsummerworkshop.storage.HelpCategoryRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class HelpFragmentViewModel(
    private val application: App
) : AndroidViewModel(application) {

    private val _currentHelp = MutableLiveData<List<Datas.HelpCategory>>()
    val currentHelp: LiveData<List<Datas.HelpCategory>> = _currentHelp

    private val repository: HelpCategoryRepository

    private val compositeDisposable = CompositeDisposable()


    init {
        val helpCategoryDao = AppDataBase.getDataBase(application).getHelpCategoryDao()
        repository = HelpCategoryRepository(helpCategoryDao)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun loadNews() {
        repository.loadHelpList()
    }

    private fun saveHelpCategory(helps: List<Datas.HelpCategory>) {
        _currentHelp.postValue(helps)
        repository.saveHelps(helps)
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
