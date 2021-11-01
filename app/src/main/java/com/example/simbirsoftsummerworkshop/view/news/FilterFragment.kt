package com.example.simbirsoftsummerworkshop.view.news

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.adapters.RecyclerAdapter
import com.example.simbirsoftsummerworkshop.databinding.FragmentFilterBinding
import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.model.DataServise
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import com.example.simbirsoftsummerworkshop.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_filter.*

class FilterFragment : BaseFragment<FragmentFilterBinding>() {
    private val viewModel: NewsViewModel by activityViewModels()
    private var listCategory = DataServise.getCategory()

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
            val sortCategory = viewModel.saveAndGetCategory(listCategory as MutableList<Datas.FilterCategory>)
            viewModel.sortNews(sortCategory)
            findNavController().navigate(R.id.action_to_newsFragment)
        }
    }
}
