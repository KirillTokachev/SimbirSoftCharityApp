package com.example.simbirsoftsummerworkshop.repository

import com.example.simbirsoftsummerworkshop.model.Datas

typealias personsListener = (List<Datas.User>) -> Unit
typealias UserListener = (Datas.User) -> Unit

interface UserRepository{
    fun loadUserData(): Datas.User

    fun loadUsers(): List<Datas.User>

    fun installListenerFriendsList(listener: personsListener)

    fun deleteFriendsListener(listener: personsListener)

    fun installUserListener(listener: UserListener)

    fun deleteUserListener(listener: UserListener)
}