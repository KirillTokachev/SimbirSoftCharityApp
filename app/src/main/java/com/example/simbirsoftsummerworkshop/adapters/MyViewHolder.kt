package com.example.simbirsoftsummerworkshop.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.friends_item.view.*

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var avatarImageView: ImageView? = null
    var name: TextView? = null

    init {
        avatarImageView = itemView.text_view_avatar_profile
        name = itemView.text_view_name_friend
    }

}