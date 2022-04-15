package com.example.simbirsoftsummerworkshop.view.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simbirsoftsummerworkshop.App
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.adapters.JsonAdapter
import com.example.simbirsoftsummerworkshop.adapters.RecyclerAdapter
import com.example.simbirsoftsummerworkshop.databinding.FragmentFilterBinding
import com.example.simbirsoftsummerworkshop.factories.factory
import com.example.simbirsoftsummerworkshop.storage.StorageFilterCategory
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import com.example.simbirsoftsummerworkshop.view.news.NewsViewModel
import kotlinx.android.synthetic.main.fragment_filter.*

class FilterFragment : BaseFragment() {
    private val viewModel: NewsViewModel by activityViewModels { factory() }
    private var listCategory = StorageFilterCategory().loadCategory()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFilterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    private fun setUpViews() {
        setUpButton()
        recycler_view_filter.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = RecyclerAdapter(listCategory)
        }
    }

    private fun setUpButton() {
        filter_button_back.setOnClickListener {
            findNavController().navigate(R.id.action_to_newsFragment)
        }

        filter_button_accept.setOnClickListener {
            val sortCategory = viewModel.saveAndInitCategory(listCategory)
            if (sortCategory.isEmpty()) {
                (activity?.application as? App)?.let { viewModel.fetchNews(it.serverApi) }
            } else {
                viewModel.sortNews(sortCategory)
            }
            val flag = true
            viewModel.initFlag(flag)
            findNavController().navigate(R.id.action_to_newsFragment)
        }
    }
}
