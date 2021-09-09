package com.example.simbirsoftsummerworkshop.view.fragments

import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.adapters.FriendsAdapter
import com.example.simbirsoftsummerworkshop.data.Data
import com.example.simbirsoftsummerworkshop.databinding.FragmentProfileBinding
import com.example.simbirsoftsummerworkshop.viewmodel.SharedViewModel
import kotlinx.android.synthetic.main.fragment_profile.*
import java.time.format.DateTimeFormatter

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    private var profileData: Data? = null
    private val viewModel: SharedViewModel by activityViewModels()

    override fun getViewBinding() = FragmentProfileBinding.inflate(layoutInflater)

    override fun setUpViews() {
        profileData = Data(resources)

            Glide.with(requireContext())
                .load(R.drawable.image_man)
                .centerInside()
                .into(image_view_item_avatar_profile)

        setUpUser()

        viewModel.keyRequest.observe(viewLifecycleOwner) {
            when (it) {
                KEY_CREATE -> {
                    viewModel.photoData.observe(viewLifecycleOwner) { it ->
                        val photo = viewModel.fileToBitmap(it)
                        Glide.with(requireContext())
                            .load(photo)
                            .centerInside()
                            .into(image_view_item_avatar_profile)
                    }
                }
                KEY_DELETE -> {
                    Glide.with(requireContext())
                        .load(R.drawable.image_man)
                        .centerInside()
                        .into(image_view_item_avatar_profile)
                }
            }
        }

        recycler_view_friends.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = profileData?.getPerson()?.let { FriendsAdapter(it.friends) }
        }

        image_view_item_avatar_profile.setOnClickListener{
            showDialog()
        }
    }

    private fun setUpUser() {
        text_view_name_profile.text = profileData?.getPerson()?.name
        text_view_data.text = profileData?.getPerson()?.dateOfBirth?.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))
        text_view_field_description.text = profileData?.getPerson()?.profession
        switch_push.isChecked = profileData?.getPerson()?.push == true
    }

    private fun showDialog(){
        EditPhotoFragment().show(
            childFragmentManager, EditPhotoFragment.TAG)
    }

    companion object {
        const val KEY_DELETE = "Delete"
        const val KEY_CREATE = "Create"
    }

}


