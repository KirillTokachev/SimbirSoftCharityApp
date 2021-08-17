package com.example.simbirsoftsummerworkshop


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simbirsoftsummerworkshop.adapters.FriendsAdapter
import com.example.simbirsoftsummerworkshop.data.FriendsDataBase
import com.example.simbirsoftsummerworkshop.databinding.FragmentSplashBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_profile.*


private  const val TIME_SLEEP: Long = 1700

class SplashFragment : Fragment() {
    lateinit var binding: FragmentSplashBinding

    private val background = object: Thread() {
        override fun run() {
            try {
                sleep(TIME_SLEEP)
                (activity as MainActivity).navController
                    .navigate(R.id.action_splashFragment_to_mainFragment22)
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


}