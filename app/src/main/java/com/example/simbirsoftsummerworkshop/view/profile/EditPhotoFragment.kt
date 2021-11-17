package com.example.simbirsoftsummerworkshop.view.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.databinding.FragmentEditPhotoBinding
import com.example.simbirsoftsummerworkshop.utils.ChangePhotoEnum
import com.example.simbirsoftsummerworkshop.utils.factory
import kotlinx.android.synthetic.main.fragment_edit_photo.*

class EditPhotoFragment : DialogFragment() {
    companion object {
        const val TAG = "PurchaseConfirmationDialog"
    }

    private lateinit var binding: FragmentEditPhotoBinding
    private val viewModel: ProfileViewModel by activityViewModels { factory() }
    private val getAction = registerForActivityResult(ActivityResultContracts.GetContent()) {
        viewModel.saveUri(it)
        viewModel.saveKey(ChangePhotoEnum.UPLOAD)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditPhotoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpButtons()
    }

    private fun setUpButtons() {
        photo_button.setOnClickListener { openCamera() }
        delete_button.setOnClickListener {
            viewModel.saveKey(ChangePhotoEnum.DELETE)
        }
        upload_button.setOnClickListener {
            getAction.launch("image/*")
        }
    }

    private fun openCamera() {
        findNavController().navigate(R.id.action_profileFragment_to_cameraFragment)
        viewModel.saveKey(ChangePhotoEnum.CREATE)
    }
}
