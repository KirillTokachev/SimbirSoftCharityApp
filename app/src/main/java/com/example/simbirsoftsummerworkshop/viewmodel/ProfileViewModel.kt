package com.example.simbirsoftsummerworkshop.viewmodel

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simbirsoftsummerworkshop.data.PersonDataBase
import java.io.File

class ProfileViewModel : ViewModel() {
    private var photoUri = MutableLiveData<Uri>()

    val photoPath: LiveData<Uri> = photoUri

    private lateinit var profileData: PersonDataBase

    fun savePhoto(uri: Uri) {
        photoUri.value = uri
    }

    fun fileToBitmap (file: File) : Bitmap {
        val bitmap: Bitmap
        val currentPhotoFile = file.toPath().toString()
        BitmapFactory.decodeFile(currentPhotoFile).also {
            val matrix = Matrix()
            val orientation = ExifInterface(currentPhotoFile).getAttributeInt(
                ExifInterface.TAG_ORIENTATION,
                ExifInterface.ORIENTATION_NORMAL
            )
            matrix.postRotate(
                when (orientation) {
                    ExifInterface.ORIENTATION_ROTATE_90 -> {
                        90f
                    }
                    ExifInterface.ORIENTATION_ROTATE_180 -> {
                        180f
                    }
                    ExifInterface.ORIENTATION_ROTATE_270 -> {
                        270f
                    }
                    else -> {
                        0f
                    }
                }
            )
            bitmap = Bitmap.createBitmap(
                it, 0, 0, it.width, it.height, matrix, true
            )
        }
        return bitmap
    }

}