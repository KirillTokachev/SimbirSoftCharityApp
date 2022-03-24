package com.example.simbirsoftsummerworkshop.view.help

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.simbirsoftsummerworkshop.App
import com.example.simbirsoftsummerworkshop.adapters.RecyclerAdapter
import com.example.simbirsoftsummerworkshop.databinding.FragmentHelpBinding
import com.example.simbirsoftsummerworkshop.factories.factory
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_help.*

const val SPAN_COUNT = 2

class HelpFragment : BaseFragment() {
    lateinit var binding: FragmentHelpBinding
    private val viewModel: HelpFragmentViewModel by activityViewModels { factory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHelpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity?.application as? App)?.let { viewModel.fetchHelpCategory(it.serverApi) }
        setUpViews()
    }

    private fun setUpViews() {
        viewModel.loadNews()

        viewModel.currentHelp.observe(viewLifecycleOwner) { helps ->
            Observable.just(helps)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext {
                    recycler_view_help.apply {
                        layoutManager = GridLayoutManager(context, SPAN_COUNT)
                        adapter = RecyclerAdapter(it)
                    }
                    progress_bar_help.visibility = GONE
                }
                .subscribe()
        }
    }
}
