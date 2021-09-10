package com.example.simbirsoftsummerworkshop.view.fragments

import android.util.Log
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_help.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_profile.*

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override fun getViewBinding() = FragmentMainBinding.inflate(layoutInflater)

    override fun setUpViews() {
        setupNav()
    }

    private fun setupNav() {
        val navController = (childFragmentManager.findFragmentById(R.id.main_container_view) as? NavHostFragment)?.navController
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
            Log.d("dest", "${navController?.currentDestination}")
        }

        navController?.addOnDestinationChangedListener { controller, destination, arguments ->
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

}