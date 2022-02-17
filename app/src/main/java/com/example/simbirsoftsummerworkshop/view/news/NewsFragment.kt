package com.example.simbirsoftsummerworkshop.view.news

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.adapters.JsonAdapter
import com.example.simbirsoftsummerworkshop.adapters.RecyclerAdapter
import com.example.simbirsoftsummerworkshop.databinding.FragmentNewsBinding
import com.example.simbirsoftsummerworkshop.factories.factory
import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : BaseFragment() {
    private var mCount = 0
    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NewsViewModel by activityViewModels { factory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        if (viewModel.isEmptyNews()) {
            val observable1 = Observable.just(JsonAdapter(requireContext()).getNews())
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
                    viewModel.initNews(it)
                }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupNewsLIst()
    }

    private fun showBadge(count: Int, news: List<Datas.News>) {
        mCount = count
        for (news in news) {
            if (news.read) {
                mCount--
            }
        }

        val navBar: BottomNavigationView = (requireActivity()).findViewById(R.id.bottom_navigation)
        val badge = navBar.getOrCreateBadge(R.id.nav_graph_news)

        val observable = Observable.just(mCount)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        val subject = PublishSubject.create<Int>()
        observable.subscribe(subject)

        subject.subscribe(
            {
                badge.isVisible = mCount > 0
                badge.number = mCount
            },
            {
                throw IllegalArgumentException("$it")
            },
            {
                Log.d("Test", "OnComplete")
            }
        )
    }

    private fun setupViews() {
        setupButton()
    }

    private fun setupNewsLIst() {
        viewModel.news.observe(viewLifecycleOwner) { result ->
            renderingResult(
                root = binding.root,
                result = result,
                onSuccess = {
                    progress_bar_news.visibility = View.GONE
                    val baseAdapter = RecyclerAdapter(it)
                    showBadge(it.size, it)
                    recycler_view_news.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = baseAdapter
                        baseAdapter.itemClickListener = { view, item, position ->
                            findNavController().navigate(R.id.action_to_nav_graph_detail)
                            it[position].read = true
                            viewModel.saveAndInitDetailNews(it[position])
                        }
                    }
                },
                onPending = {
                    bnv.visibility = View.GONE
                    recycler_view_news.visibility = View.GONE
                },
                onFailure = {
                    progress_bar_news.visibility = View.GONE
                    bnv.visibility = View.GONE
                    recycler_view_news.visibility = View.GONE
                }
            )
        }
    }

    private fun setupButton() {
        filter_button.setOnClickListener {
            findNavController().navigate(R.id.action_newsFragment_to_filterFragment)
        }
    }
}
