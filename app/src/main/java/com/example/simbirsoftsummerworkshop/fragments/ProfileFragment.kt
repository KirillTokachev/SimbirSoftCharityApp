package com.example.simbirsoftsummerworkshop.fragments

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simbirsoftsummerworkshop.adapters.FriendsAdapter
import com.example.simbirsoftsummerworkshop.data.PersonDataBase
import com.example.simbirsoftsummerworkshop.databinding.FragmentProfileBinding
import com.example.simbirsoftsummerworkshop.viewmodel.CameraViewModel
import com.example.simbirsoftsummerworkshop.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.*
import java.time.format.DateTimeFormatter

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    private lateinit var profileData: PersonDataBase
    private val viewModel: CameraViewModel by viewModels()
    override fun getViewBinding() = FragmentProfileBinding.inflate(layoutInflater)

    override fun setUpViews() {
        profileData = PersonDataBase(resources)
        /*Glide.with(requireContext())
            .load(profileData.person.avatar)
            .centerInside()
            .into(image_view_avatar_profile)*/

        setUpUser()

        viewModel.photoPath.observe(viewLifecycleOwner, Observer { it ->
            image_view_avatar_profile.setImageURI(it)
            /*Glide.with(requireContext())
                .load(profileData.person.avatar)
                .centerInside()
                .placeholder(R.mipmap.icon_profile_round)
                .into(image_view_avatar_profile)*/

        })
        recycler_view_friends.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = FriendsAdapter(profileData.person.friends)
        }
        image_view_avatar_profile.setOnClickListener{
            showDialog()
        }
    }

    private fun setUpUser() {
        text_view_name_profile.text = profileData.person.name
        text_view_data.text = profileData.person.dateOfBirth.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))
        text_view_field_description.text = profileData.person.profession
        switch_push.isChecked = profileData.person.push
    }

    private fun showDialog(){
        EditPhotoFragment().show(
            childFragmentManager, EditPhotoFragment.TAG)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }

}


