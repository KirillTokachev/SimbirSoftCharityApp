package com.example.simbirsoftsummerworkshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simbirsoftsummerworkshop.adapters.FriendsAdapter
import com.example.simbirsoftsummerworkshop.data.FriendsDataBase
import com.example.simbirsoftsummerworkshop.databinding.FragmentProfileBinding
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

    companion object {
        fun newInstance() = ProfileFragment()
    }
}
