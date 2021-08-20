package com.example.simbirsoftsummerworkshop


import com.example.simbirsoftsummerworkshop.databinding.FragmentMainBinding
import com.example.simbirsoftsummerworkshop.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment<FragmentMainBinding>() {

    override fun getViewBinding() = FragmentMainBinding.inflate(layoutInflater)

    override fun setUpViews() {
        bottom_navigation.apply {
            background = null
            menu.getItem(2).isEnabled = false
            selectedItemId = R.id.bottom_menu_profile
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

}
