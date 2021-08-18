package com.example.simbirsoftsummerworkshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.simbirsoftsummerworkshop.databinding.FragmentSplashBinding

private const val TIME_SLEEP: Long = 1700

class SplashFragment : Fragment() {
    lateinit var binding: FragmentSplashBinding

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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        background.start()
        binding = FragmentSplashBinding.inflate(inflater)
        return binding.root
    }

    companion object {
        fun newInstance() = SplashFragment()
    }
}
