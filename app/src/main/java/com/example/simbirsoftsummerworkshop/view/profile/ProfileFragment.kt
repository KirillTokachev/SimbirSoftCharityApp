package com.example.simbirsoftsummerworkshop.view.profile

import android.annotation.SuppressLint
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.adapters.RecylcerAdapter
import com.example.simbirsoftsummerworkshop.databinding.FragmentProfileBinding
import com.example.simbirsoftsummerworkshop.model.DataServise
import com.example.simbirsoftsummerworkshop.utils.ChangePhotoEnum
import com.example.simbirsoftsummerworkshop.utils.factory
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import com.example.simbirsoftsummerworkshop.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    private val viewModel: ProfileViewModel by activityViewModels { factory() }

    override fun getViewBinding() = FragmentProfileBinding.inflate(layoutInflater)

    override fun setUpViews() {

        Glide.with(requireContext())
            .load(R.drawable.image_man)
            .centerInside()
            .into(avatar_profile_image)

        setUpUser()

        viewModel.keyRequest.observe(viewLifecycleOwner) {
            if (it != null) {
                when (it) {
                    ChangePhotoEnum.CREATE -> {
                        viewModel.photoData.observe(viewLifecycleOwner) { file ->
                            val photo = viewModel.fileToBitmap(file)
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
                    else -> throw IllegalStateException()
                }
            } else {
                throw NullPointerException()
            }
        }

        avatar_profile_image.setOnClickListener {
            showDialog()
        }
    }

    @SuppressLint("NewApi")
    private fun setUpUser() {
        viewModel.setUpUser(name_profile_text, data_text, field_description_text, switch_push)

        recycler_view_friends.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = RecylcerAdapter(DataServise.initUser().friends)
        }
    }

    private fun showDialog() {
        EditPhotoFragment().show(
            childFragmentManager, EditPhotoFragment.TAG
        )
    }
}
