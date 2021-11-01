package com.example.simbirsoftsummerworkshop.view.fragments

import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.*


private const val GONE = View.GONE
private const val VISIBLE = View.VISIBLE

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
                R.id.cameraFragment -> setupBottomNavVisible(GONE)
                R.id.detailFragment -> setupBottomNavVisible(GONE)
                else -> setupBottomNavVisible(VISIBLE)
            }
        }
    }

    private fun setupBottomNavVisible(visibility: Int) {
        when (visibility) {
            VISIBLE -> {
                bottom_app_bar.visibility = visibility
                bottom_navigation.visibility = visibility
                fb_help.visibility = visibility
            }
            GONE -> {
                bottom_app_bar.visibility = visibility
                bottom_navigation.visibility = visibility
                fb_help.visibility = visibility
            }
        }
    }
}
