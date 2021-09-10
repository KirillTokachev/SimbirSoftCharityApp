package com.example.simbirsoftsummerworkshop.view.fragments.tabs

import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simbirsoftsummerworkshop.adapters.EventAdapter
import com.example.simbirsoftsummerworkshop.data.Data
import com.example.simbirsoftsummerworkshop.databinding.FragmentEventsBinding
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_events.*
import kotlinx.android.synthetic.main.fragment_events.recycler_view_nko

class EventsFragment : BaseFragment<FragmentEventsBinding>() {
    private var searchTextView: TextView? = null
    override fun getViewBinding() = FragmentEventsBinding.inflate(layoutInflater)

    override fun setUpViews() {
        setUpSearchResult()
        recycler_view_nko.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = EventAdapter(Data(resources).getEvents())
        }
    }

    private fun setUpSearchResult() {
        searchTextView = search_event_result_text
        searchTextView?.text = Data(resources).getResult(searchTextView?.text as String)
    }
}
