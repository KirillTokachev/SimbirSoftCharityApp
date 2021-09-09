package com.example.simbirsoftsummerworkshop.view.fragments.onboarding

import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simbirsoftsummerworkshop.adapters.EventAdapter
import com.example.simbirsoftsummerworkshop.data.Data
import com.example.simbirsoftsummerworkshop.databinding.FragmentEventsBinding
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_events.*
import kotlinx.android.synthetic.main.fragment_events.recycler_view_nko_search

class EventsFragment : BaseFragment<FragmentEventsBinding>() {
    private var searchTextView: TextView? = null
    override fun getViewBinding() = FragmentEventsBinding.inflate(layoutInflater)

    override fun setUpViews() {
        setUpSearchResult()
        recycler_view_nko_search.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = EventAdapter(Data(resources).getEvents())
        }
    }

    private fun setUpSearchResult () {
        searchTextView = text_view_search_event_result
        searchTextView?.text = Data(resources).getResult(searchTextView?.text as String)
    }
}