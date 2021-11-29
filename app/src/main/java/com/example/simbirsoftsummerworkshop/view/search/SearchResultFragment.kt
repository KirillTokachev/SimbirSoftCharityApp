package com.example.simbirsoftsummerworkshop.view.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simbirsoftsummerworkshop.adapters.RecyclerAdapter
import com.example.simbirsoftsummerworkshop.databinding.FragmentSearchResultBinding
import com.example.simbirsoftsummerworkshop.storage.StorageEvent
import kotlinx.android.synthetic.main.fragment_search_result.*

class SearchResultFragment : Fragment() {
    private var searchTextView: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSearchResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    private fun setUpViews() {
        setUpSearchResult()
        recycler_view_result.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = RecyclerAdapter(StorageEvent().loadEvent())
        }
    }

    private fun setUpSearchResult() {
        searchTextView = search_event_result_text
        searchTextView?.text = StorageEvent().loadResult()
    }

    override fun onPause() {
        super.onPause()
        recycler_view_result.apply {
            adapter = RecyclerAdapter(StorageEvent().loadEvent())
        }
    }
}
