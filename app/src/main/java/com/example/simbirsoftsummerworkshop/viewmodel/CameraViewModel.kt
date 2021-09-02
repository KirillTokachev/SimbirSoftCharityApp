package com.example.simbirsoftsummerworkshop.viewmodel

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class CameraViewModel : ViewModel() {
    private val photoUri : MutableLiveData<Uri> by lazy {
        MutableLiveData<Uri>()
    }
    val photoPath: LiveData<Uri> = photoUri

    fun savePhoto (uri: Uri) {
        photoUri.value = uri
    }
}