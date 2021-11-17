package com.example.simbirsoftsummerworkshop.view.filter

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.adapters.JsonAdapter
import com.example.simbirsoftsummerworkshop.adapters.RecyclerAdapter
import com.example.simbirsoftsummerworkshop.databinding.FragmentFilterBinding
import com.example.simbirsoftsummerworkshop.storage.StorageFilterCategory
import com.example.simbirsoftsummerworkshop.utils.factory
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import com.example.simbirsoftsummerworkshop.view.news.NewsViewModel
import kotlinx.android.synthetic.main.fragment_filter.*

class FilterFragment : BaseFragment<FragmentFilterBinding>() {
    private val viewModel: NewsViewModel by activityViewModels { factory() }
    private var listCategory = StorageFilterCategory().loadCategory()

    override fun getViewBinding() = FragmentFilterBinding.inflate(layoutInflater)

    override fun setUpViews() {
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
                viewModel.saveNews(JsonAdapter(requireContext()).getNews())
            } else {
                viewModel.sortNews(sortCategory)
            }

            findNavController().navigate(R.id.action_to_newsFragment)
        }
    }
}
