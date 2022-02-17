package com.example.simbirsoftsummerworkshop.model

import androidx.annotation.DrawableRes
import org.threeten.bp.LocalDate

sealed class Datas {
    data class FilterCategory(
        val name: String,
        var push: Boolean
    ) : Datas()

    data class Event(
        val name: String
    ) : Datas()

    data class HelpCategory(
        val name: String,
        val icon: String
    ) : Datas()

    data class News(
        val id: Int,
        val name: String,
        val avatarNews: String,
        val description: String,
        val dateStart: LocalDate,
        val dateEnd: LocalDate,
        val helpCategory: List<String>,
        val fullDescription: String,
        val newsImages: List<String>,
        val address: String,
        val phone: String,
        val company: String,
        var read: Boolean = false
    ) : Datas()

    data class User(
        val name: String,
        val dateOfBirth: LocalDate,
        val profession: String,
        @DrawableRes val avatar: Int,
        val friends: List<User>,
        val push: Boolean = false
    ) : Datas()
}
