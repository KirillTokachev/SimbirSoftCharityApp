package com.example.simbirsoftsummerworkshop

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.simbirsoftsummerworkshop.databinding.ActivityMainBinding
import com.example.simbirsoftsummerworkshop.view.profile.CameraFragment
import com.example.simbirsoftsummerworkshop.view.profile.ProfileFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var mainNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mainNavHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_container) as NavHostFragment
        mainNavController = mainNavHostFragment.findNavController()

        supportFragmentManager.registerFragmentLifecycleCallbacks(
            object : FragmentManager.FragmentLifecycleCallbacks() {
                override fun onFragmentViewCreated(fm: FragmentManager, f: Fragment, v: View, savedInstanceState: Bundle?) {
                    visibility(f)
                }
            },
            true
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        return mainNavController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun visibility(fragment: Fragment) {
        when (fragment) {
            is ProfileFragment -> {
                bottom_navigation.visibility = View.VISIBLE
                fb_help.visibility = View.VISIBLE
                bottom_app_bar.visibility = View.VISIBLE
            }
            is CameraFragment -> {
                bottom_navigation.visibility = View.GONE
                fb_help.visibility = View.GONE
                bottom_app_bar.visibility = View.GONE
            }
        }
    }

}
