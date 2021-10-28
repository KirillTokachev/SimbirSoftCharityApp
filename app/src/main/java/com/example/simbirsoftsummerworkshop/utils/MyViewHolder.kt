package com.example.simbirsoftsummerworkshop.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.events_item.view.*
import kotlinx.android.synthetic.main.filter_item.view.*
import kotlinx.android.synthetic.main.friends_item.view.*
import kotlinx.android.synthetic.main.help_item.view.*
import kotlinx.android.synthetic.main.news_item.view.*

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var name: TextView? = null
    var nameEvent: TextView? = null
    var nameNews: TextView? = null
    var nameFilter: TextView? = null
    var helpTitleCategory: TextView? = null
    var newsDescription: TextView? = null
    var newsDate: TextView? = null
    var helpImageView: ImageView? = null
    var avatarImageView: ImageView? = null
    var avatarNews: ImageView? = null
    var filterPush: SwitchCompat? = null
    var separatorFilter: View? = null

    init {
        name = itemView.friend_name_text
        nameEvent = itemView.text_view_event_name
        nameNews = itemView.news_title
        nameFilter = itemView.name_filter
        helpTitleCategory = itemView.help_category_text
        newsDescription = itemView.news_descr
        newsDate = itemView.date_news
        helpImageView = itemView.help_category_image
        avatarImageView = itemView.avatar_profile_image
        avatarNews = itemView.news_avatar
        filterPush = itemView.switch_push_filter
        separatorFilter = itemView.upper_divider_filter
    }
}
