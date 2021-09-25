package com.example.simbirsoftsummerworkshop.view.profile

import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.adapters.FriendsAdapter
import com.example.simbirsoftsummerworkshop.data.Data
import com.example.simbirsoftsummerworkshop.databinding.FragmentProfileBinding
import com.example.simbirsoftsummerworkshop.utils.Constants
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import com.example.simbirsoftsummerworkshop.viewmodel.SharedViewModel
import kotlinx.android.synthetic.main.fragment_profile.*
import java.time.format.DateTimeFormatter

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    private var profileData: Data? = null
    private val viewModel: SharedViewModel by activityViewModels()

    override fun getViewBinding() = FragmentProfileBinding.inflate(layoutInflater)

    override fun setUpViews() {
        profileData = Data()

        Glide.with(requireContext())
            .load(R.drawable.image_man)
            .centerInside()
            .into(avatar_profile_image)

        setUpUser()

        viewModel.keyRequest.observe(viewLifecycleOwner) {
            when (it) {
                Constants.CREATE -> {
                    viewModel.photoData.observe(viewLifecycleOwner) { it ->
                        val photo = viewModel.fileToBitmap(it)
                        Glide.with(requireContext())
                            .load(photo)
                            .centerInside()
                            .into(avatar_profile_image)
                    }
                }
                Constants.DELETE -> {
                    Glide.with(requireContext())
                        .clear(avatar_profile_image)
                }
                Constants.UPLOAD -> {
                    viewModel.uriPhoto.observe(viewLifecycleOwner) { uri ->
                        Glide.with(requireContext())
                            .load(uri)
                            .centerInside()
                            .into(avatar_profile_image)
                    }
                }
            }
        }

        recycler_view_friends.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = profileData?.getPerson()?.let { FriendsAdapter(it.friends)}
        }

        avatar_profile_image.setOnClickListener {
            showDialog()
        }
    }

    private fun setUpUser() {
        name_profile_text.text = profileData?.getPerson()?.name
        data_text.text = profileData?.getPerson()?.dateOfBirth?.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))
        field_description_text.text = profileData?.getPerson()?.profession
        switch_push.isChecked = profileData?.getPerson()?.push == true
    }

    private fun showDialog() {
        EditPhotoFragment().show(
            childFragmentManager, EditPhotoFragment.TAG
        )
    }

    companion object {
        const val KEY_DELETE = "Delete"
        const val KEY_CREATE = "Create"
        const val KEY_UPLOAD = "Upload"
    }
}
