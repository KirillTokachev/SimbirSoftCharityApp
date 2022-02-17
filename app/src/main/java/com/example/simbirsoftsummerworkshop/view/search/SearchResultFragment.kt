package com.example.simbirsoftsummerworkshop.view.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simbirsoftsummerworkshop.adapters.RecyclerAdapter
import com.example.simbirsoftsummerworkshop.databinding.FragmentSearchResultBinding
import com.example.simbirsoftsummerworkshop.factories.factory
import kotlinx.android.synthetic.main.fragment_search_result.*

class SearchResultFragment : Fragment() {
    private val viewModel: SearchViewModel by activityViewModels { factory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSearchResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    private fun setUpViews() {
        setUpSearchResult()
        viewModel.events.observe(viewLifecycleOwner) {
            when (it.isEmpty()) {
                true -> search_no_result.visibility = VISIBLE
                false -> search_no_result.visibility = GONE
            }
            recycler_view_result.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = RecyclerAdapter(it)
            }
        }
    }

    private fun setUpSearchResult() {
        search_event_result_text.text = viewModel.loadResultSearchCount()
    }
}
