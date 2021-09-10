package com.example.simbirsoftsummerworkshop.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.databinding.FragmentEditPhotoBinding
import com.example.simbirsoftsummerworkshop.viewmodel.SharedViewModel
import kotlinx.android.synthetic.main.fragment_edit_photo.*

class EditPhotoFragment : DialogFragment() {
    private lateinit var binding: FragmentEditPhotoBinding
    private val viewModel: SharedViewModel by activityViewModels()

    companion object {
        const val TAG = "PurchaseConfirmationDialog"
        const val KEY_DELETE = "Delete"
        const val KEY_CREATE = "Create"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
            Log.d("dest", "${findNavController().currentDestination}")
            viewModel.saveKey(KEY_DELETE)
        }
    }

    private fun openCamera() {
        findNavController().navigate(R.id.action_to_cameraFragment)
        viewModel.saveKey(KEY_CREATE)
    }
}
