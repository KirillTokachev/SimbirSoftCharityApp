package com.example.simbirsoftsummerworkshop.adapters

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.databinding.*
import com.example.simbirsoftsummerworkshop.model.*
import com.example.simbirsoftsummerworkshop.utils.Util.getTime
import com.squareup.picasso.Picasso

sealed class ViewHolders(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        const val CHILD = "child.png"
        const val ADULTS = "adults.png"
        const val ELDERLY = "elderly.png"
        const val ANIMALS = "animals.png"
        const val EVENTS = "events.png"
        const val NEWS_1 = "news_1.png"
        const val NEWS_2 = "news_2.png"
    }

    var itemClickListener: ((view: View, item: Datas, position: Int) -> Unit)? = null
    val picasso: Picasso = Picasso.get()

    class EventViewHolder(private val binding: EventsItemBinding) : ViewHolders(binding) {
        fun bind(eventName: Datas.Event) {
            binding.textViewEventName.text = eventName.name
        }
    }

    class FilterViewHolder(private val binding: FilterItemBinding) : ViewHolders(binding) {
        fun bind(filterCategory: Datas.FilterCategory) {
            binding.apply {
                nameFilterItem.text = filterCategory.name
                switchPushFilterItem.isChecked = filterCategory.push
                switchPushFilterItem.setOnCheckedChangeListener { _, isChecked ->
                    filterCategory.push = isChecked
                }
            }
        }
    }

    class FriendsViewHolder(private val binding: FriendsItemBinding) : ViewHolders(binding) {
        fun bind(users: Datas.User) {
            binding.apply {
                avatarProfileImage.setImageResource(users.avatar)
                userName.text = users.name
            }
        }
    }

    class HelpViewHolder(private val binding: HelpItemBinding) : ViewHolders(binding) {
        fun bind(helpCategory: Datas.HelpCategory) {
            binding.apply {
                when (helpCategory.icon) {
                    CHILD -> {
                        picasso.load(R.drawable.child)
                            .into(helpCategoryImage)
                    }
                    ADULTS -> {
                        picasso.load(R.drawable.adults)
                            .into(helpCategoryImage)
                    }
                    ELDERLY -> {
                        picasso.load(R.drawable.elderly)
                            .into(helpCategoryImage)
                    }
                    ANIMALS -> {
                        picasso.load(R.drawable.animals)
                            .into(helpCategoryImage)
                    }
                    EVENTS -> {
                        picasso.load(R.drawable.events)
                            .into(helpCategoryImage)
                    }
                }
                helpCategoryText.text = helpCategory.name
            }
        }
    }

    class NewsViewHolder(private val binding: NewsItemBinding) : ViewHolders(binding) {
        @SuppressLint("CheckResult")
        fun bind(news: Datas.News) {
            binding.apply {
                when (news.avatarNews) {
                    NEWS_1 -> {
                        picasso.load(R.drawable.news_1)
                            .into(newsAvatar)
                    }
                    NEWS_2 -> {
                        picasso.load(R.drawable.news_2)
                            .into(newsAvatar)
                    }
                }
                newsTitle.text = news.name
                newsDescr.text = news.description
                dateNews.text = getTime(news)
            }
            binding.root.setOnClickListener {
                itemClickListener?.invoke(it, news, adapterPosition)
            }
        }
    }
}
