package com.example.simbirsoftsummerworkshop.view.profile

import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.adapters.FriendsAdapter
import com.example.simbirsoftsummerworkshop.data.Data
import com.example.simbirsoftsummerworkshop.databinding.FragmentProfileBinding
import com.example.simbirsoftsummerworkshop.utils.ChangePhotoEnum
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import com.example.simbirsoftsummerworkshop.viewmodel.SharedViewModel
import kotlinx.android.synthetic.main.fragment_profile.*
import java.time.format.DateTimeFormatter

private const val DATA = "dd MMMM yyyy"

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
                ChangePhotoEnum.CREATE -> {
                    viewModel.photoData.observe(viewLifecycleOwner) { it ->
                        val photo = viewModel.fileToBitmap(it)
                        Glide.with(requireContext())
                            .load(photo)
                            .centerInside()
                            .into(avatar_profile_image)
                    }
                }
                ChangePhotoEnum.DELETE -> {
                    Glide.with(requireContext())
                        .clear(avatar_profile_image)
                }
                ChangePhotoEnum.UPLOAD -> {
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
            adapter = profileData?.initUser()?.let { FriendsAdapter(it.friends)}
        }

        avatar_profile_image.setOnClickListener {
            showDialog()
        }
    }

    private fun setUpUser() {
        name_profile_text.text = profileData?.initUser()?.name
        data_text.text = profileData?.initUser()?.dateOfBirth?.format(DateTimeFormatter.ofPattern(DATA))
        field_description_text.text = profileData?.initUser()?.profession
        switch_push.isChecked = profileData?.initUser()?.push == true
    }

    private fun showDialog() {
        EditPhotoFragment().show(
            childFragmentManager, EditPhotoFragment.TAG
        )
    }
}
