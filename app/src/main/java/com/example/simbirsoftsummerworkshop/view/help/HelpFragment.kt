package com.example.simbirsoftsummerworkshop.view.help

import android.util.Log
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.simbirsoftsummerworkshop.adapters.JsonAdapter
import com.example.simbirsoftsummerworkshop.adapters.RecyclerAdapter
import com.example.simbirsoftsummerworkshop.databinding.FragmentHelpBinding
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_help.*

private const val SPAN_COUNT = 2

class HelpFragment : BaseFragment<FragmentHelpBinding>() {

    override fun getViewBinding() = FragmentHelpBinding.inflate(layoutInflater)

    override fun setUpViews() {
        recycler_view_help.apply {
            layoutManager = GridLayoutManager(context, SPAN_COUNT)
            adapter = RecyclerAdapter(JsonAdapter().getCategory(requireContext()))
        }
    }
}
