package com.example.simbirsoftsummerworkshop


import com.example.simbirsoftsummerworkshop.databinding.FragmentSplashBinding
import com.example.simbirsoftsummerworkshop.fragments.BaseFragment

private const val TIME_SLEEP: Long = 1700

class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    override fun getViewBinding() = FragmentSplashBinding.inflate(layoutInflater)

    private val background = object : Thread() {
        override fun run() {
            try {
                sleep(TIME_SLEEP)
                (activity as MainActivity).mainNavController
                    .navigate(R.id.action_splashFragment_to_mainFragment)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun setUpViews() {
        background.start()
    }

}
