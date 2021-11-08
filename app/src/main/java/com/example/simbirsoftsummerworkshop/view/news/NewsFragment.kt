package com.example.simbirsoftsummerworkshop.view.news

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.adapters.RecyclerAdapter
import com.example.simbirsoftsummerworkshop.adapters.JsonAdapter
import com.example.simbirsoftsummerworkshop.databinding.FragmentNewsBinding
import com.example.simbirsoftsummerworkshop.model.DataServise
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import com.example.simbirsoftsummerworkshop.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : BaseFragment<FragmentNewsBinding>() {
    private val viewModel: NewsViewModel by activityViewModels()

    override fun getViewBinding() = FragmentNewsBinding.inflate(layoutInflater)

    override fun setUpViews() {
        setupNewsLIst()
        setUpButton()
        setupNews()
    }

    private fun setupNews() {
        setupNewsLIst()
    }

    private fun setupNewsLIst() {
        if (DataServise.getNews().isEmpty()) {
            val newsList = JsonAdapter().getNews(requireContext())
            val baseAdapter = RecyclerAdapter(newsList)
            recycler_view_news.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = baseAdapter
                baseAdapter.itemClickListener = { view, item, position ->
                    findNavController().navigate(R.id.action_to_nav_graph_detail)
                    viewModel.saveAndInitDetailNews(newsList[position])
                }
            }
        } else {
            setUpSortedNewsLIst()
        }
    }

    private fun setUpSortedNewsLIst() {
        viewModel.news.observe(viewLifecycleOwner) { news ->
            val baseAdapter = RecyclerAdapter(news)
            recycler_view_news.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = baseAdapter
                baseAdapter.itemClickListener = { view, item, position ->
                    findNavController().navigate(R.id.action_to_nav_graph_detail)
                }
            }
        }
    }

    private fun setUpButton() {
        filter_button.setOnClickListener {
            findNavController().navigate(R.id.action_newsFragment_to_filterFragment)
            viewModel.saveNews(JsonAdapter().getNews(requireContext()))
        }
    }
}
