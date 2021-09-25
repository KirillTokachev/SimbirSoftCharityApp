package com.example.simbirsoftsummerworkshop.view.search

import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simbirsoftsummerworkshop.adapters.EventAdapter
import com.example.simbirsoftsummerworkshop.data.Data
import com.example.simbirsoftsummerworkshop.databinding.FragmentSearchResultBinding
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_search_result.*

class SearchResultFragment : BaseFragment<FragmentSearchResultBinding>() {
    private var searchTextView: TextView? = null
    override fun getViewBinding() = FragmentSearchResultBinding.inflate(layoutInflater)

    override fun setUpViews() {
        setUpSearchResult()
        recycler_view_result.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = EventAdapter(Data().getEvents())
        }
    }

    private fun setUpSearchResult() {
        searchTextView = search_event_result_text
        searchTextView?.text = Data().getResult(searchTextView?.text as String)
    }

    override fun onPause() {
        super.onPause()
        recycler_view_result.apply {
            adapter = EventAdapter(Data().getEvents())
        }
    }

}
