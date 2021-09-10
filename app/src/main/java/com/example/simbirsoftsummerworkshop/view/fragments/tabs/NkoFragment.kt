package com.example.simbirsoftsummerworkshop.view.fragments.tabs

import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simbirsoftsummerworkshop.adapters.NkoAdapter
import com.example.simbirsoftsummerworkshop.data.Data
import com.example.simbirsoftsummerworkshop.databinding.FragmentNkoBinding
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_nko.*
import kotlinx.android.synthetic.main.fragment_nko.recycler_view_nko

class NkoFragment : BaseFragment<FragmentNkoBinding>() {
    private var searchTextView: TextView? = null
    override fun getViewBinding() = FragmentNkoBinding.inflate(layoutInflater)

    override fun setUpViews() {
        setUpSearchResult()
        recycler_view_nko.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = NkoAdapter(Data(resources).getNko())
        }
    }

    private fun setUpSearchResult() {
        searchTextView = text_view_search_nko_result
        searchTextView?.text = Data(resources).getResult(searchTextView?.text as String)
    }
}
