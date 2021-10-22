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

class BaseAdapter<T>(itemLIst: List<T>) : RecyclerView.Adapter<BaseViewHolder>() {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            R.layout.events_item -> BaseViewHolder.EventViewHolder(
                EventsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            R.layout.filter_item -> BaseViewHolder.FilterViewHolder(
                FilterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            R.layout.friends_item -> BaseViewHolder.FriendsViewHolder(
                FriendsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            R.layout.help_item -> BaseViewHolder.HelpViewHolder(
                HelpItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            R.layout.news_item -> BaseViewHolder.NewsViewHolder(
                NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else -> throw IllegalArgumentException(INVALID_VIEW_TYPE_TEXT)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.itemClickListener = itemClickListener
        when (holder) {
            is BaseViewHolder.EventViewHolder -> holder.bind(items[position] as Datas.Event)
            is BaseViewHolder.FilterViewHolder -> holder.bind(items[position] as Datas.FilterCategory)
            is BaseViewHolder.FriendsViewHolder -> holder.bind(items[position] as Datas.User)
            is BaseViewHolder.HelpViewHolder -> holder.bind(items[position] as Datas.HelpCategory)
            is BaseViewHolder.NewsViewHolder -> holder.bind(items[position] as Datas.News)
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
