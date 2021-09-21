package com.example.simbirsoftsummerworkshop.fragments


import androidx.navigation.fragment.findNavController
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.databinding.FragmentSplashBinding

private const val TIME_SLEEP: Long = 1700

class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    override fun getViewBinding() = FragmentSplashBinding.inflate(layoutInflater)

    private val background = object : Thread() {
        override fun run() {
            try {
                sleep(TIME_SLEEP)
                findNavController().navigate(R.id.action_to_mainFragment)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun setUpViews() {
        background.start()
    }

}
