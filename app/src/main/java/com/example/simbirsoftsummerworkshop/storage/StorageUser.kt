package com.example.simbirsoftsummerworkshop.storage

import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.model.Datas
import com.example.simbirsoftsummerworkshop.repository.UserListener
import com.example.simbirsoftsummerworkshop.repository.UserRepository
import com.example.simbirsoftsummerworkshop.repository.personsListener
import org.threeten.bp.LocalDate

class StorageUser : UserRepository {
    companion object {
        private val friendsList: List<Datas.User> by lazy {
            listOf(
                Datas.User(
                    name = "Дмитрий Валерьевич",
                    dateOfBirth = LocalDate.of(1992, 8, 16),
                    profession = "Хирург",
                    avatar = R.drawable.avatar_2,
                    friends = mutableListOf()
                ),
                Datas.User(
                    name = "Евгений Александров",
                    dateOfBirth = LocalDate.of(1991, 12, 12),
                    profession = "Терапевт",
                    avatar = R.drawable.avatar_1,
                    friends = mutableListOf()
                ),
                Datas.User(
                    name = "Виктор Кузницов",
                    dateOfBirth = LocalDate.of(1988, 5, 7),
                    profession = "Плотник",
                    avatar = R.drawable.avatar,
                    friends = mutableListOf()
                ),
                Datas.User(
                    name = "Дмитрий Валерьевич",
                    dateOfBirth = LocalDate.of(1992, 3, 13),
                    profession = "Хирург",
                    avatar = R.drawable.avatar_2,
                    friends = mutableListOf()
                ),
                Datas.User(
                    name = "Евгений Александров",
                    dateOfBirth = LocalDate.of(1991, 12, 12),
                    profession = "Терапевт",
                    avatar = R.drawable.avatar_1,
                    friends = mutableListOf()
                ),
                Datas.User(
                    name = "Виктор Кузницов",
                    dateOfBirth = LocalDate.of(1988, 5, 7),
                    profession = "Плотник",
                    avatar = R.drawable.avatar,
                    friends = mutableListOf()
                )
            )
        }

        private val user: Datas.User by lazy {
            Datas.User(
                name = "Константинов Денис",
                dateOfBirth = LocalDate.of(1980, 2, 1),
                profession = "Хирургия, трамвотология",
                avatar = R.drawable.image_man,
                friends = friendsList,
                push = true
            )
        }
    }

    private val listenerFriends = mutableSetOf<personsListener>()

    private val userListener = mutableSetOf<UserListener>()

    private fun loadFriends(): List<Datas.User> = friendsList

    override fun loadUserData(): Datas.User {
        return user
    }

    override fun loadUsers(): List<Datas.User> {
        return loadFriends()
    }

    override fun installListenerFriendsList(listener: personsListener) {
        listenerFriends += listener
        listener(loadFriends())
    }

    override fun deleteFriendsListener(listener: personsListener) {
        listenerFriends -= listener
    }

    override fun installUserListener(listener: UserListener) {
        userListener += listener
        listener(loadUserData())
    }

    override fun deleteUserListener(listener: UserListener) {
        userListener -= listener
    }
}