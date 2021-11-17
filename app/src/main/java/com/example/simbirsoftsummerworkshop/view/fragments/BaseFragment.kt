package com.example.simbirsoftsummerworkshop.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.simbirsoftsummerworkshop.tasks.FailureResult
import com.example.simbirsoftsummerworkshop.tasks.PendingResult
import com.example.simbirsoftsummerworkshop.tasks.Result
import com.example.simbirsoftsummerworkshop.tasks.SuccessResult
import kotlinx.android.synthetic.main.fragment_help.*

abstract class BaseFragment<VBinding : ViewBinding> : Fragment() {
    private lateinit var binding: VBinding
    protected abstract fun getViewBinding(): VBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    open fun setUpViews() {}

    private fun init() {
        binding = getViewBinding()
    }

    fun <T> renderingResult(
        root: View, result: Result<T>,
        onPending: () -> Unit,
        onFailure: (Exception) -> Unit,
        onSuccess: (T) -> Unit
    ) {
        (root as ViewGroup).children.forEach { it.visibility = View.GONE }
        when (result) {
            is PendingResult -> onPending()
            is FailureResult -> onFailure(result.error)
            is SuccessResult -> onSuccess(result.data)
        }
    }

}
