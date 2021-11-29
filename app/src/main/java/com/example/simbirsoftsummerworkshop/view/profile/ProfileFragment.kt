package com.example.simbirsoftsummerworkshop.view.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.adapters.RecyclerAdapter
import com.example.simbirsoftsummerworkshop.databinding.FragmentProfileBinding
import com.example.simbirsoftsummerworkshop.factories.factory
import com.example.simbirsoftsummerworkshop.tasks.FailureResult
import com.example.simbirsoftsummerworkshop.tasks.PendingResult
import com.example.simbirsoftsummerworkshop.tasks.SuccessResult
import com.example.simbirsoftsummerworkshop.utils.ChangePhotoEnum
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : BaseFragment() {
    private val viewModel: ProfileViewModel by activityViewModels { factory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    private fun setUpViews() {
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
                }
            } else {
                throw NullPointerException()
            }
        }

        avatar_profile_image.setOnClickListener {
            showDialog()
        }
    }

    private fun setUpUser() {
        viewModel.setUpUser(name_profile_text, data_text, field_description_text, switch_push)
        viewModel.loadFriends()

        viewModel.usersFriends.observe(viewLifecycleOwner) { result ->
            when (result) {
                is PendingResult -> {
                    profile_progress_bar.visibility = View.VISIBLE
                    recycler_view_friends.visibility = View.GONE
                }
                is FailureResult -> {
                    profile_progress_bar.visibility = View.GONE
                    recycler_view_friends.visibility = View.GONE
                }
                is SuccessResult -> {
                    profile_progress_bar.visibility = View.GONE
                    recycler_view_friends.visibility = View.VISIBLE

                    recycler_view_friends.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = RecyclerAdapter(result.data)
                    }
                }
            }
        }

    }

    private fun showDialog() {
        EditPhotoFragment().show(
            childFragmentManager, EditPhotoFragment.TAG
        )
    }
}
