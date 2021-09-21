package com.example.simbirsoftsummerworkshop.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simbirsoftsummerworkshop.adapters.FriendsAdapter
import com.example.simbirsoftsummerworkshop.data.FriendsDataBase
import com.example.simbirsoftsummerworkshop.databinding.FragmentProfileBinding
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    override fun getViewBinding() = FragmentProfileBinding.inflate(layoutInflater)

    override fun setUpViews() {
        recycler_view_friends.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = FriendsAdapter(FriendsDataBase.friendsList)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }

}