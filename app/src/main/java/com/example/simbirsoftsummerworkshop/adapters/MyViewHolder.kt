package com.example.simbirsoftsummerworkshop.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.events_item.view.*
import kotlinx.android.synthetic.main.friends_item.view.*
import kotlinx.android.synthetic.main.help_item.view.*
import kotlinx.android.synthetic.main.nko_item.view.*

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var avatarImageView: ImageView? = null
    var name: TextView? = null
    var nameEvent: TextView?
    var nameNko: TextView?
    var helpImageView: ImageView? = null
    var helpTitleCategory: TextView? = null

    init {
        avatarImageView = itemView.image_view_item_avatar_profile
        name = itemView.text_view_name_friend
        nameEvent = itemView.text_view_event_name
        nameNko = itemView.text_view_nko_name
        helpImageView = itemView.image_view_help_category
        helpTitleCategory = itemView.text_view_help_category
    }

}