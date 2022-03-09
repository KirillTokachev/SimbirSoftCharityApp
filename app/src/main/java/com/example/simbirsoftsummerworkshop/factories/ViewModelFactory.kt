package com.example.simbirsoftsummerworkshop.factories

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.simbirsoftsummerworkshop.App
import com.example.simbirsoftsummerworkshop.view.help.HelpFragmentViewModel
import com.example.simbirsoftsummerworkshop.view.news.NewsViewModel
import com.example.simbirsoftsummerworkshop.view.profile.ProfileViewModel
import com.example.simbirsoftsummerworkshop.view.search.SearchViewModel

class ViewModelFactory constructor(private val app: App) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel = when (modelClass) {
            ProfileViewModel::class.java -> {
                ProfileViewModel(app.storageUser)
            }
            NewsViewModel::class.java -> {
                NewsViewModel(app, app.storageNews, app.dispatcher)
            }
            HelpFragmentViewModel::class.java -> {
                HelpFragmentViewModel(app, app.storageHelpCategory, app.dispatcher)
            }
            SearchViewModel::class.java -> {
                SearchViewModel(app.storageEvent)
            }
            else -> {
                throw IllegalArgumentException("Unknown view model class")
            }
        }
        return viewModel as T
    }
}
fun Fragment.factory() = ViewModelFactory(requireContext().applicationContext as App)
