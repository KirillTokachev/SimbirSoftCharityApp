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
        avatarImageView = itemView.avatar_profile_image
        name = itemView.friend_name_text
        nameEvent = itemView.text_view_event_name
        nameNko = itemView.nko_name_text
        helpImageView = itemView.help_category_image
        helpTitleCategory = itemView.help_category_text
    }
}
