package com.example.simbirsoftsummerworkshop.viewmodel

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simbirsoftsummerworkshop.utils.Constants
import java.io.File

class SharedViewModel : ViewModel() {
    private val photoFile: MutableLiveData<File> by lazy {
        MutableLiveData<File>()
    }
    val photoData: LiveData<File> = photoFile

    private val key: MutableLiveData<Constants> by lazy {
        MutableLiveData<Constants>()
    }
    val keyRequest: LiveData<Constants> = key

    private val uriFile: MutableLiveData<Uri> by lazy {
        MutableLiveData<Uri>()
    }
    val uriPhoto: LiveData<Uri> = uriFile

    fun saveUri (uri: Uri) {
        uriFile.value = uri
    }

    fun savePhoto(file: File) {
        photoFile.value = file
    }

    fun saveKey(constants: Constants) {
        key.value = constants
    }

    fun fileToBitmap(file: File): Bitmap {
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
                        ORIENTATION_90
                    }
                    ExifInterface.ORIENTATION_ROTATE_180 -> {
                        ORIENTATION_180
                    }
                    ExifInterface.ORIENTATION_ROTATE_270 -> {
                        ORIENTATION_270
                    }
                    else -> {
                        ORIENTATION_0
                    }
                }
            )
            bitmap = Bitmap.createBitmap(
                it, 0, 0, it.width, it.height, matrix, true
            )
        }
        return bitmap
    }

    companion object {
        private const val ORIENTATION_90 = 90f
        private const val ORIENTATION_180  = 180f
        private const val ORIENTATION_270 = 270f
        private const val ORIENTATION_0 = 0f
    }
}
