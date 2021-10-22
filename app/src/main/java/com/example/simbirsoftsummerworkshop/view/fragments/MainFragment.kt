package com.example.simbirsoftsummerworkshop.view.fragments

import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override fun getViewBinding() = FragmentMainBinding.inflate(layoutInflater)

    override fun setUpViews() {
        setupNav()
    }

    private fun setupNav() {
        val navController =
            (childFragmentManager.findFragmentById(R.id.main_container_view) as? NavHostFragment)?.navController
        if (navController != null) {
            setupWithNavController(bottom_navigation, navController)
        }

        bottom_navigation.apply {
            background = null
            menu.getItem(2).isEnabled = false
            selectedItemId = R.id.helpFragment
        }

        fb_help.setOnClickListener {
            navController?.navigate(R.id.helpFragment)
            bottom_navigation.selectedItemId = R.id.helpFragment
        }

        navController?.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.cameraFragment -> hideBottomNav()
                R.id.detailFragment -> hideBottomNav()
                else -> showBottomNav()
            }
        }
    }

    private fun showBottomNav() {
        bottom_app_bar.visibility = View.VISIBLE
        bottom_navigation.visibility = View.VISIBLE
        fb_help.visibility = View.VISIBLE
    }

    private fun hideBottomNav() {
        bottom_app_bar.visibility = View.GONE
        bottom_navigation.visibility = View.GONE
        fb_help.visibility = View.GONE
    }
}
