package com.example.simbirsoftsummerworkshop.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.databinding.*
import com.example.simbirsoftsummerworkshop.model.*
import com.example.simbirsoftsummerworkshop.utils.DiffCallback

class RecylcerAdapter<T>(itemLIst: List<T>) : RecyclerView.Adapter<ViewHolders>() {
    companion object {
        private const val INVALID_VIEW_TYPE_TEXT = "Invalid ViewType Provided"
        private const val INVALID_POSITION_TEXT = "Invalid position"
    }

    private var items = itemLIst
        set(newValue) {
            val diffCallback = DiffCallback(field, newValue)
            val diffResult = DiffUtil.calculateDiff(diffCallback)
            field = newValue
            diffResult.dispatchUpdatesTo(this)
        }

    var itemClickListener: ((view: View, item: Datas, position: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolders {
        return when (viewType) {
            R.layout.events_item -> ViewHolders.EventViewHolder(
                EventsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            R.layout.filter_item -> ViewHolders.FilterViewHolder(
                FilterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            R.layout.friends_item -> ViewHolders.FriendsViewHolder(
                FriendsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            R.layout.help_item -> ViewHolders.HelpViewHolder(
                HelpItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            R.layout.news_item -> ViewHolders.NewsViewHolder(
                NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else -> throw IllegalArgumentException(INVALID_VIEW_TYPE_TEXT)
        }
    }

    override fun onBindViewHolder(holders: ViewHolders, position: Int) {
        holders.itemClickListener = itemClickListener
        when (holders) {
            is ViewHolders.EventViewHolder -> holders.bind(items[position] as Datas.Event)
            is ViewHolders.FilterViewHolder -> holders.bind(items[position] as Datas.FilterCategory)
            is ViewHolders.FriendsViewHolder -> holders.bind(items[position] as Datas.User)
            is ViewHolders.HelpViewHolder -> holders.bind(items[position] as Datas.HelpCategory)
            is ViewHolders.NewsViewHolder -> holders.bind(items[position] as Datas.News)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is Datas.Event -> R.layout.events_item
            is Datas.FilterCategory -> R.layout.filter_item
            is Datas.User -> R.layout.friends_item
            is Datas.HelpCategory -> R.layout.help_item
            is Datas.News -> R.layout.news_item
            else -> throw IllegalArgumentException(INVALID_POSITION_TEXT)
        }
    }

    override fun getItemCount(): Int = items.size
}
