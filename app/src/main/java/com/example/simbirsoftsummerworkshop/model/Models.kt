package com.example.simbirsoftsummerworkshop.model

import androidx.annotation.DrawableRes
import androidx.room.*
import com.example.simbirsoftsummerworkshop.data_base.ListToStringConverter
import org.threeten.bp.LocalDate

sealed class Datas {
    data class FilterCategory(
        val name: String,
        var push: Boolean
    ) : Datas()

    data class Event(
        val name: String
    ) : Datas()

    @Entity(tableName = "help_category")
    data class HelpCategory(
        @PrimaryKey val id: Int,
        val name: String,
        val icon: String
    ) : Datas()

    @Entity(tableName = "news")
    data class News(
        @PrimaryKey val id: Int,
        val name: String,
        @ColumnInfo(name = "avatar_news") val avatarNews: String,
        val description: String,
        @ColumnInfo(name = " date_start") val dateStart: Long,
        @ColumnInfo(name = "date_end") val dateEnd: Long,
        @TypeConverters(ListToStringConverter::class)
        @ColumnInfo(name = "help_category") val helpCategory: List<String>,
        @ColumnInfo(name = "full_description") val fullDescription: String,
        @TypeConverters(ListToStringConverter::class)
        @ColumnInfo(name = "news_images") val newsImages: List<String>,
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
