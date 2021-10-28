package com.example.simbirsoftsummerworkshop.viewmodel

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.model.DataServise
import com.example.simbirsoftsummerworkshop.utils.ChangePhotoEnum
import com.example.simbirsoftsummerworkshop.utils.Orientation
import java.io.File

class ProfileViewModel(
    private val service: DataServise
) : ViewModel() {
    private val photoFile: MutableLiveData<File> by lazy {
        MutableLiveData<File>()
    }
    val photoData: LiveData<File> = photoFile

    private val key: MutableLiveData<ChangePhotoEnum> by lazy {
        MutableLiveData<ChangePhotoEnum>()
    }
    val keyRequest: LiveData<ChangePhotoEnum> = key

    private val uriFile: MutableLiveData<Uri> by lazy {
        MutableLiveData<Uri>()
    }
    val uriPhoto: LiveData<Uri> = uriFile

    private val _users = MutableLiveData<List<Datas.User>>()
    val users: LiveData<List<Datas.User>> = _users

    @SuppressLint("NewApi")
    fun setUpUser(name: TextView, date: TextView, profession: TextView, push: SwitchCompat) {
        name.text = service.initUser().name
        date.text = service
            .initUser().dateOfBirth.format(org.threeten.bp.format.DateTimeFormatter.ISO_LOCAL_DATE)
        profession.text = service.initUser().profession
        push.isChecked = service.initUser().push
    }

    fun saveUri(uri: Uri) {
        uriFile.value = uri
    }

    fun savePhoto(file: File) {
        photoFile.value = file
    }

    fun saveKey(changePhotoEnum: ChangePhotoEnum) {
        key.value = changePhotoEnum
    }

    @SuppressLint("NewApi")
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
                        Orientation.ORIENTATION_90.grades
                    }
                    ExifInterface.ORIENTATION_ROTATE_180 -> {
                        Orientation.ORIENTATION_180.grades
                    }
                    ExifInterface.ORIENTATION_ROTATE_270 -> {
                        Orientation.ORIENTATION_270.grades
                    }
                    else -> {
                        Orientation.ORIENTATION_0.grades
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
