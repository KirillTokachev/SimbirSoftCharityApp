package com.example.simbirsoftsummerworkshop.fragments


import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override fun getViewBinding() = FragmentMainBinding.inflate(layoutInflater)

    override fun setUpViews() {
        setupNav()
        bottom_navigation.apply {
            background = null
            menu.getItem(2).isEnabled = false
            selectedItemId = R.id.bottom_menu_profile
        }
    }

    private fun setupNav() {
        val navController = findNavController()
        bottom_navigation.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.mainFragment -> showBottomNav()
                R.id.cameraFragment -> hideBottomNav()
            }
        }
    }

    private fun showBottomNav() {
        bottom_navigation.visibility = View.VISIBLE

    }

    private fun hideBottomNav() {
        bottom_navigation.visibility = View.GONE

    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

}