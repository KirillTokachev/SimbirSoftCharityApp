package com.example.simbirsoftsummerworkshop.view.help

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.simbirsoftsummerworkshop.adapters.JsonAdapter
import com.example.simbirsoftsummerworkshop.adapters.RecyclerAdapter
import com.example.simbirsoftsummerworkshop.databinding.FragmentHelpBinding
import com.example.simbirsoftsummerworkshop.factories.factory
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_help.*

const val SPAN_COUNT = 2

class HelpFragment : BaseFragment() {
    lateinit var binding: FragmentHelpBinding
    private val viewModel: HelpFragmentViewModel by activityViewModels { factory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHelpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViews()
    }

    private fun setUpViews() {
        viewModel.saveHelpCategory(JsonAdapter(requireActivity()).getCategory())
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

