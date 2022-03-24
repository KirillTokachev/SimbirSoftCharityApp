package com.example.simbirsoftsummerworkshop.data_base

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.repository.HelpCategoryDao
import com.example.simbirsoftsummerworkshop.repository.NewsDao

@Database(entities = [Datas.HelpCategory::class, Datas.News::class], version = 2)
@TypeConverters(ListToStringConverter::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getHelpCategoryDao(): HelpCategoryDao
    abstract fun getNewsDao(): NewsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDataBase(context: Context): AppDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDataBase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}