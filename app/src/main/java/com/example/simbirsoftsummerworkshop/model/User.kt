package com.example.simbirsoftsummerworkshop.model

import android.graphics.Bitmap
import java.io.File
import java.time.LocalDate

data class User(
    val name: String,
    val dateOfBirth: LocalDate,
    val profession: String,
    var avatar: Bitmap,
    val friends: MutableList<User>,
    val push: Boolean = false
)

