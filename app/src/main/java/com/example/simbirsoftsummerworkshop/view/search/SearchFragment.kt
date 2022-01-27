package com.example.simbirsoftsummerworkshop.view.search

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.adapters.JsonAdapter
import com.example.simbirsoftsummerworkshop.adapters.ViewPagerAdapter
import com.example.simbirsoftsummerworkshop.databinding.FragmentSearchBinding
import com.example.simbirsoftsummerworkshop.factories.factory
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_search.*
import java.util.concurrent.TimeUnit

class SearchFragment : BaseFragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private lateinit var tabLayout: TabLayout
    private var viewPager: ViewPager2? = null
    private val viewModel: SearchViewModel by activityViewModels { factory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()

        Observable.create(ObservableOnSubscribe<String> { emitter ->
            search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    emitter.onNext(query!!)
                    search_view.clearFocus()
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    emitter.onNext(newText!!)
                    return false
                }
            })
        })
            .subscribeOn(Schedulers.io())
            .map { text -> text.lowercase().trim() }
            .debounce(500, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                if (viewModel.loadEvents().isEmpty()) initEvents()

                when (it.isNotBlank()) {
                    true -> {
                        viewModel.saveSearchEvent(viewModel.loadEvents().filter { event ->
                            event.name.contains(it, true)
                        })
                        viewModel.saveEvents(viewModel.loadSearchEvent())
                    }
                    false -> {
                        viewModel.clearEvents()
                    }
                }
            }
    }

    private fun setUpViews() {
        setupViewPager()
        setupTabLayout()
    }

    private fun initEvents() {
        viewModel.saveEvents(JsonAdapter(requireContext()).getEvents())
    }

    private fun setupTabLayout() {
        tabLayout = tab_layout
        viewPager?.let {
            TabLayoutMediator(tabLayout, it) { tab, position ->
                when (position) {
                    0 -> tab.text = activity?.getString(R.string.events)
                    1 -> tab.text = activity?.getString(R.string.charity)
                }
            }.attach()
        }
    }

    private fun setupViewPager() {
        viewPager = pager
        val adapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        viewPager?.adapter = adapter
    }


}