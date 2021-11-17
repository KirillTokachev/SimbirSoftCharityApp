package com.example.simbirsoftsummerworkshop.repository

import com.example.simbirsoftsummerworkshop.model.Datas

typealias UsersListener = (List<Datas.User>) -> Unit
typealias UserListener = (Datas.User) -> Unit

interface UserRepository {

    fun loadUserData(): Datas.User

    fun loadUsers(): List<Datas.User>

    fun addListenerFriendsList(listener: UsersListener)

    fun removeFriendsListener(listener: UsersListener)

    fun addUserListener(listener: UserListener)

    fun removeUserListener(listener: UserListener)

}