package com.example.simbirsoftsummerworkshop.view.news

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
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
import com.example.simbirsoftsummerworkshop.json_helper.JsonAsync
import com.example.simbirsoftsummerworkshop.json_helper.JsonIntentService
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.fragment_news.view.*

class NewsFragment : BaseFragment() {
    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NewsViewModel by activityViewModels { factory() }

    /*lateinit var broadcastReceiver: JsonIntentService.MyBroadcastReceiver
    var isLoaded = false*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* if (savedInstanceState == null) {

            // Async
            *//*JsonAsync(view.context, this).execute()*//*

            //Executor
            *//*JsonHelperExecutor().submit(view.context, view.news_recycler, view.progressBarNews)*//*

            // IntentService
            *//*JsonIntentService().start(view.context)*//*
        }*/

        /*broadcastReceiver =
            JsonIntentService.MyBroadcastReceiver(view.recycler_view_news, view.progress_bar_news)
        val intentFilter = IntentFilter(JsonIntentService.ACTION)
        intentFilter.addCategory(Intent.CATEGORY_DEFAULT)
        context?.registerReceiver(broadcastReceiver, intentFilter)*/

        setUpViews()
    }

    private fun setUpViews() {
        setUpButton()
        setupNewsLIst()

    }

    private fun setupNewsLIst() {
        when (viewModel.isEmptyNews().isNullOrEmpty()) {
            true -> {
                viewModel.initNews(JsonAdapter(requireContext()).getNews())
                viewModel.news.observe(viewLifecycleOwner) { result ->
                    renderingResult(
                        root = binding.root,
                        result = result,
                        onSuccess = {
                            progress_bar_news.visibility = View.GONE
                            val baseAdapter = RecyclerAdapter(it)
                            recycler_view_news.apply {
                                layoutManager = LinearLayoutManager(context)
                                adapter = baseAdapter
                                baseAdapter.itemClickListener = { view, item, position ->
                                    findNavController().navigate(R.id.action_to_nav_graph_detail)
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
            false -> {
                viewModel.initNews(JsonAdapter(requireContext()).getNews())
                viewModel.news.observe(viewLifecycleOwner) { result ->
                    renderingResult(
                        root = binding.root,
                        result = result,
                        onSuccess = {
                            progress_bar_news.visibility = View.GONE
                            val baseAdapter = RecyclerAdapter(it)
                            recycler_view_news.apply {
                                layoutManager = LinearLayoutManager(context)
                                adapter = baseAdapter
                                baseAdapter.itemClickListener = { view, item, position ->
                                    findNavController().navigate(R.id.action_to_nav_graph_detail)
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
        }
    }

    private fun setUpButton() {
        filter_button.setOnClickListener {
            findNavController().navigate(R.id.action_newsFragment_to_filterFragment)
        }
    }
}
