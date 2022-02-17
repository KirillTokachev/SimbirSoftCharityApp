package com.example.simbirsoftsummerworkshop.view.help

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.simbirsoftsummerworkshop.adapters.JsonAdapter
import com.example.simbirsoftsummerworkshop.adapters.RecyclerAdapter
import com.example.simbirsoftsummerworkshop.databinding.FragmentHelpBinding
import com.example.simbirsoftsummerworkshop.factories.factory
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.BiFunction
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

        setUpViews()
    }

    private fun setUpViews() {
        val observable1 = Observable.just(JsonAdapter(requireActivity()).getCategory())
        observable1.subscribeOn(Schedulers.newThread())
            .doOnNext {
                Log.d("TestCurrentThread", "Current thread " + Thread.currentThread().name)
            }
            .observeOn(Schedulers.newThread())

        val observable2 = Observable.just("Hello")
        observable2.subscribeOn(Schedulers.newThread())
            .doOnNext {
                Log.d("TestCurrentThread", "Current thread " + Thread.currentThread().name)
            }
            .observeOn(Schedulers.newThread())

        Observable.combineLatest(
            observable1,
            observable2,
            BiFunction { t1, t2 ->
                for (i in t1.indices) {
                    t1[i].name + t2
                }
                t1
            }
        )
            .subscribeOn(Schedulers.io())
            .subscribeOn(Schedulers.newThread())
            .doAfterNext {
                Log.d("TestCurrentThread", "Current thread " + Thread.currentThread().name)
            }
            .observeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                Log.d("TestCurrentThread", "Current thread " + Thread.currentThread().name)
            }
            .subscribe {
                viewModel.saveHelpCategory(it)
            }

        viewModel.currentHelp.observe(viewLifecycleOwner) { result ->
            renderingResult(
                root = binding.root,
                result = result,
                onSuccess = {
                    progress_bar_help.visibility = GONE
                    recycler_view_help.apply {
                        layoutManager = GridLayoutManager(context, SPAN_COUNT)
                        adapter = RecyclerAdapter(it)
                    }
                },
                onFailure = {
                    progress_bar_help.visibility = GONE
                    recycler_view_help.visibility = GONE
                },
                onPending = {
                    recycler_view_help.visibility = GONE
                }
            )
        }
    }
}
