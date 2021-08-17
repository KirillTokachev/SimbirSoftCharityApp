package com.example.simbirsoftsummerworkshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.simbirsoftsummerworkshop.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bottom_navigation.apply {
            background = null
            menu.getItem(2).isEnabled = false
            selectedItemId = R.id.bottom_menu_profile
        }

            bottom_navigation.setOnItemSelectedListener {
                when (it.itemId){
                    R.id.bottom_menu_profile -> (activity as MainActivity).navController.navigate(R.id.action_mainFragment2_to_profileFragment2)
                }
                true
            }
        }

    companion object {

    fun newInstance() = MainFragment()

    }

}
