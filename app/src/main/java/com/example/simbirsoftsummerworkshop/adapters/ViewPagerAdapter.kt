package com.example.simbirsoftsummerworkshop.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.simbirsoftsummerworkshop.view.fragments.onboarding.EventsFragment
import com.example.simbirsoftsummerworkshop.view.fragments.onboarding.NkoFragment

class ViewPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
       return when (position) {
            0 -> EventsFragment()
            1 -> NkoFragment()
            else -> Fragment()
        }
    }

}