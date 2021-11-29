package com.example.simbirsoftsummerworkshop.view.fragments

import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.fragment.app.Fragment
import com.example.simbirsoftsummerworkshop.tasks.*

abstract class BaseFragment : Fragment() {

    fun <T> renderingResult(
        root: ViewGroup, result: Result<T>,
        onPending: () -> Unit,
        onFailure: (Exception) -> Unit,
        onSuccess: (T) -> Unit
    ) {
        (root).children.forEach { it.visibility = View.VISIBLE }
        when (result) {
            is PendingResult -> onPending()
            is FailureResult -> onFailure(result.error)
            is SuccessResult -> onSuccess(result.data)
        }
    }
}
