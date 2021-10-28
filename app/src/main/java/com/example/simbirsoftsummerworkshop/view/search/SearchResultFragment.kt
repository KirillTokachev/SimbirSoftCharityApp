package com.example.simbirsoftsummerworkshop.view.search

import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simbirsoftsummerworkshop.adapters.RecylcerAdapter
import com.example.simbirsoftsummerworkshop.databinding.FragmentSearchResultBinding
import com.example.simbirsoftsummerworkshop.model.DataServise
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_search_result.*

class SearchResultFragment : BaseFragment<FragmentSearchResultBinding>() {
    private var searchTextView: TextView? = null
    override fun getViewBinding() = FragmentSearchResultBinding.inflate(layoutInflater)

    override fun setUpViews() {
        setUpSearchResult()
        recycler_view_result.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = RecylcerAdapter(DataServise.getEvents())
        }
    }

    private fun setUpSearchResult() {
        searchTextView = search_event_result_text
        searchTextView?.text = DataServise.getResult()
    }

    override fun onPause() {
        super.onPause()
        recycler_view_result.apply {
            adapter = RecylcerAdapter(DataServise.getEvents())
        }
    }
}
