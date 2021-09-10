package com.example.simbirsoftsummerworkshop.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.simbirsoftsummerworkshop.view.fragments.tabs.EventsFragment
import com.example.simbirsoftsummerworkshop.view.fragments.tabs.NkoFragment

class ViewPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> EventsFragment()
            1 -> NkoFragment()
            else -> Fragment()
        }
    }
}
