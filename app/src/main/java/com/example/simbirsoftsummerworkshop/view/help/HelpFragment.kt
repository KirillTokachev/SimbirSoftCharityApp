package com.example.simbirsoftsummerworkshop.view.help

import android.util.Log
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.simbirsoftsummerworkshop.adapters.JsonAdapter
import com.example.simbirsoftsummerworkshop.adapters.RecylcerAdapter
import com.example.simbirsoftsummerworkshop.databinding.FragmentHelpBinding
import com.example.simbirsoftsummerworkshop.model.DataServise
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_help.*

private const val SPAN_COUNT = 2

class HelpFragment : BaseFragment<FragmentHelpBinding>() {

    override fun getViewBinding() = FragmentHelpBinding.inflate(layoutInflater)

    override fun setUpViews() {
        recycler_view_help.apply {
            Log.d("dest", "${findNavController().currentDestination}")
            layoutManager = GridLayoutManager(context, SPAN_COUNT)
            adapter = RecylcerAdapter(JsonAdapter().getCategory(requireContext()))
        }
    }
}
