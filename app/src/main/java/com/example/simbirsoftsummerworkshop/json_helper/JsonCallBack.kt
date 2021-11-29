package com.example.simbirsoftsummerworkshop.json_helper

interface JsonCallBack<T> {
    fun onSuccess(result: T)
    fun onFailure(e: Exception)
}