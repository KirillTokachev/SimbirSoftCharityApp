package com.example.simbirsoftsummerworkshop.utils

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.simbirsoftsummerworkshop.App
import com.example.simbirsoftsummerworkshop.viewmodel.NewsViewModel
import com.example.simbirsoftsummerworkshop.viewmodel.ProfileViewModel

class ViewModelFactory(private val app: App) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val viewModel = when (modelClass) {
            ProfileViewModel::class.java -> {
                ProfileViewModel(app.dataService)
            }
            NewsViewModel::class.java -> {
                NewsViewModel(app.dataService)
            }
            else -> throw IllegalArgumentException("Unknown view model class")
        }
        return viewModel as T
    }
}

fun Fragment.factory() = ViewModelFactory(requireContext().applicationContext as App)
