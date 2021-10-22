package com.example.simbirsoftsummerworkshop.view.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.simbirsoftsummerworkshop.R

private const val TIME_SLEEP: Long = 1700

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.postDelayed(
            {
                findNavController().navigate(
                    R.id.action_splashFragment_to_mainFragment, bundleOf(),
                    navOptions {
                        anim {
                            enter = R.anim.slide_in
                            exit = R.anim.slide_out
                            popEnter = R.anim.nav_default_pop_enter_anim
                            popExit = R.anim.nav_default_pop_exit_anim
                        }
                        launchSingleTop = true
                        popUpTo(R.id.app_nav_graph) {
                            inclusive = true
                        }
                    }
                )
            },
            TIME_SLEEP
        )
    }
}
