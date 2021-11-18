package com.example.simbirsoftsummerworkshop.view.help

import android.view.View.GONE
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.simbirsoftsummerworkshop.adapters.JsonAdapter
import com.example.simbirsoftsummerworkshop.adapters.RecyclerAdapter
import com.example.simbirsoftsummerworkshop.databinding.FragmentHelpBinding
import com.example.simbirsoftsummerworkshop.storage.StorageHelpCategory
import com.example.simbirsoftsummerworkshop.utils.factory
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_help.*

const val SPAN_COUNT = 2

class HelpFragment : BaseFragment<FragmentHelpBinding>() {
    private val viewModel: HelpFragmentViewModel by activityViewModels { factory() }

    override fun getViewBinding() = FragmentHelpBinding.inflate(layoutInflater)

    override fun setUpViews() {
        StorageHelpCategory().setHelpCategory(JsonAdapter(requireContext()).getCategory())
        viewModel.currentHelp.observe(viewLifecycleOwner) { result ->
            renderingResult(
                root = binding.root,
                result = result,
                onSuccess = {
                    progress_bar_help.visibility = GONE
                    recycler_view_help.apply {
                        layoutManager = GridLayoutManager(context, SPAN_COUNT)
                        adapter = RecyclerAdapter(it)
                    }
                },
                onFailure = {
                    progress_bar_help.visibility = GONE
                    recycler_view_help.visibility = GONE
                },
                onPending = {
                    recycler_view_help.visibility = GONE
                }
            )
        }
    }
}
