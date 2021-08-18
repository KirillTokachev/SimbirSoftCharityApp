package com.example.simbirsoftsummerworkshop.data

import java.time.LocalDate

data class Person(
    val name: String,
    val dateOfBirth: LocalDate,
    val profession: String,
    val avatarId: Int,
    val push: Boolean = false
)
