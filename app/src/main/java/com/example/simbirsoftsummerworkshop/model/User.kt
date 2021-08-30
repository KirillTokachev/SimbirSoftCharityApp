package com.example.simbirsoftsummerworkshop.model

import java.time.LocalDate

data class User(
    val name: String,
    val dateOfBirth: LocalDate,
    val profession: String,
    val avatar: Int,
    val push: Boolean = false
)

