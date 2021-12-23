package com.example.simbirsoftsummerworkshop.repository

import com.example.simbirsoftsummerworkshop.model.Datas

typealias personsListener = (List<Datas.User>) -> Unit
typealias UserListener = (Datas.User) -> Unit

interface UserRepository : Repository {
    fun loadUserData(): Datas.User

    fun loadUsers(): List<Datas.User>

    override fun addListener(listener: Listener) {
        installListenerFriendsList(listener)
    }

    override fun removeListener(listener: Listener) {
        deleteFriendsListener(listener)
    }

    fun installListenerFriendsList(listener: personsListener)

    fun deleteFriendsListener(listener: personsListener)

    fun installUserListener(listener: UserListener)

    fun deleteUserListener(listener: UserListener)
}