package com.example.simbirsoftsummerworkshop.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.databinding.FragmentEditPhotoBinding
import kotlinx.android.synthetic.main.fragment_edit_photo.*
import kotlinx.android.synthetic.main.fragment_main.*

class EditPhotoFragment : DialogFragment()/*, View.OnClickListener*/ {
    lateinit var mCurrentPhotoPath: String
    private lateinit var binding: FragmentEditPhotoBinding

    companion object {
        const val CREATE_PHOTO = 1
        const val DELETE_PHOTO = 2
        const val TAG = "PurchaseConfirmationDialog"
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
        photo_button.setOnClickListener {
            openCamera()
        }

        /*override fun onClick(v: View?) {
            when (v?.id) {
                R.id.photo_button -> Log.d("test", "Click")
            (activity as MainActivity).mainNavController
                    .navigate(R.id.to_camera)
            }
        }*/


        /*@Throws(IOException::class)
        private fun createImageFile(): File {
            val timeStamp: String = SimpleDateFormat.getDateTimeInstance().format(Date())
            val storageDir: File? = activity?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)

            return File.createTempFile(
                "JPEG_${timeStamp}_",
                ".jpg",
                storageDir
            ).apply {
                mCurrentPhotoPath = absolutePath
            }
        }


        @SuppressLint("QueryPermissionsNeeded")
        override fun onClick(v: View?) {
            when (v?.id) {
                R.id.photo_button -> {
                    Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                        context?.packageManager?.let {
                            takePictureIntent.resolveActivity(it)?.also {
                                val photoFile: File? = try {
                                    createImageFile()
                                } catch (ex: IOException) {
                                    null
                                }
                                photoFile?.also {
                                    val photoUri: Uri = FileProvider.getUriForFile(
                                        requireContext(),
                                        "com.example.android.file_provider",
                                        it
                                    )
                                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
                                    setFragmentResult("keyPhoto",)
                                    startActivityForResult(takePictureIntent, CREATE_PHOTO)
                                }
                            }
                        }
                    }
                }
                R.id.delete_button -> {
                    targetFragment?.onActivityResult(targetRequestCode, DELETE_PHOTO, Intent())
                    dismiss()
                }
            }
        }*/


        /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == CREATE_PHOTO) {
                if (resultCode == RESULT_OK) {
                    try {
                        val intent = Intent().putExtra("path", mCurrentPhotoPath)
                        targetFragment?.onActivityResult(targetRequestCode, CREATE_PHOTO, intent)
                        dismiss()
                    } catch (e: FileNotFoundException) {
                        e.printStackTrace()
                    }
                }
            }

        }*/

    }

    private fun openCamera () {
        findNavController().navigate(R.id.action_to_camera_fragment)
    }

}