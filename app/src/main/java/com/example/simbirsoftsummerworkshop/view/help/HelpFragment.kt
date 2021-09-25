package com.example.simbirsoftsummerworkshop.view.help

import android.util.Log
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.simbirsoftsummerworkshop.adapters.HelpAdapter
import com.example.simbirsoftsummerworkshop.data.Data
import com.example.simbirsoftsummerworkshop.databinding.FragmentHelpBinding
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_help.*

class HelpFragment : BaseFragment<FragmentHelpBinding>() {

    override fun getViewBinding() = FragmentHelpBinding.inflate(layoutInflater)

    override fun setUpViews() {
        recycler_view_help.apply {
            Log.d("dest", "${findNavController().currentDestination}")
            layoutManager = GridLayoutManager(context, 2)
            adapter = HelpAdapter(Data().getDataHelp())
        }
    }
}
