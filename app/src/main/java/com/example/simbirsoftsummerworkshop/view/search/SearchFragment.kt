package com.example.simbirsoftsummerworkshop.view.search

import androidx.viewpager2.widget.ViewPager2
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.adapters.ViewPagerAdapter
import com.example.simbirsoftsummerworkshop.databinding.FragmentSearchBinding
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    private lateinit var tabLayout: TabLayout
    private var viewPager: ViewPager2? = null

    override fun getViewBinding() = FragmentSearchBinding.inflate(layoutInflater)

    override fun setUpViews() {
        setupViewPager()
        setupTabLayout()
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
