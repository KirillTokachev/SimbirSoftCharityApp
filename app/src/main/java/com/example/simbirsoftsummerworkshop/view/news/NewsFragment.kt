package com.example.simbirsoftsummerworkshop.view.news

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.adapters.JsonAdapter
import com.example.simbirsoftsummerworkshop.adapters.RecyclerAdapter
import com.example.simbirsoftsummerworkshop.databinding.FragmentNewsBinding
import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.storage.StorageNews
import com.example.simbirsoftsummerworkshop.tasks.FailureResult
import com.example.simbirsoftsummerworkshop.tasks.PendingResult
import com.example.simbirsoftsummerworkshop.tasks.SuccessResult
import com.example.simbirsoftsummerworkshop.utils.factory
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.coroutines.*

class NewsFragment : BaseFragment<FragmentNewsBinding>() {
    private val viewModel: NewsViewModel by activityViewModels { factory() }
    /*private var newsList = listOf<Datas.News>()*/

    override fun getViewBinding() = FragmentNewsBinding.inflate(layoutInflater)

    @DelicateCoroutinesApi
    override fun setUpViews() {
        setUpButton()
        setupNewsLIst()

    }

    private fun setupNewsLIst() {
        if (StorageNews().loadNews().isEmpty()) {
            StorageNews().setNews(JsonAdapter(requireContext()).getNews())
            viewModel.news.observe(viewLifecycleOwner) { result ->
                when (result) {
                    is PendingResult -> {
                        progress_bar_news.visibility = View.VISIBLE
                        recycler_view_news.visibility = View.GONE
                    }
                    is FailureResult -> {
                        progress_bar_news.visibility = View.GONE
                        recycler_view_news.visibility = View.GONE
                    }
                    is SuccessResult -> {
                        progress_bar_news.visibility = View.GONE
                        recycler_view_news.visibility = View.VISIBLE
                        val baseAdapter = RecyclerAdapter(result.data)
                        recycler_view_news.apply {
                            layoutManager = LinearLayoutManager(context)
                            adapter = baseAdapter
                            baseAdapter.itemClickListener = { view, item, position ->
                                findNavController().navigate(R.id.action_to_nav_graph_detail)
                                viewModel.saveAndInitDetailNews(result.data[position])
                            }
                        }

                    }
                }
            }
        } else {
            setUpSortedNewsLIst()
        }
    }

    private fun setUpSortedNewsLIst() {
        StorageNews().setNews(StorageNews().loadNews())
        viewModel.news.observe(viewLifecycleOwner) { result ->
            when (result) {
                is PendingResult -> {
                    progress_bar_news.visibility = View.VISIBLE
                    recycler_view_news.visibility = View.GONE
                }
                is FailureResult -> {
                    progress_bar_news.visibility = View.GONE
                    recycler_view_news.visibility = View.GONE
                }
                is SuccessResult -> {
                    progress_bar_news.visibility = View.GONE
                    recycler_view_news.visibility = View.VISIBLE
                    val baseAdapter = RecyclerAdapter(result.data)
                    recycler_view_news.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = baseAdapter
                        baseAdapter.itemClickListener = { view, item, position ->
                            findNavController().navigate(R.id.action_to_nav_graph_detail)
                            viewModel.saveAndInitDetailNews(result.data[position])
                        }
                    }
                }
            }
        }
    }

    private fun setUpButton() {
        filter_button.setOnClickListener {
            findNavController().navigate(R.id.action_newsFragment_to_filterFragment)
        }
    }
}
