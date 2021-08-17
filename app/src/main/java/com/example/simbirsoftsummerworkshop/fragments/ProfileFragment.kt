package com.example.simbirsoftsummerworkshop.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simbirsoftsummerworkshop.MainActivity
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.SplashFragment
import com.example.simbirsoftsummerworkshop.adapters.FriendsAdapter
import com.example.simbirsoftsummerworkshop.data.FriendsDataBase
import com.example.simbirsoftsummerworkshop.databinding.FragmentProfileBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        friends_recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = FriendsAdapter(FriendsDataBase.friendsList)
        }

    }

}