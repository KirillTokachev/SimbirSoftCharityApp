package com.example.simbirsoftsummerworkshop.utils

import androidx.recyclerview.widget.DiffUtil

class DiffCallback<T>(
    private var oldList: List<T>,
    private val newList: List<T>
) : DiffUtil.Callback() {

    private val <T> T.id: Int
        get() {
            return this.id
        }

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
