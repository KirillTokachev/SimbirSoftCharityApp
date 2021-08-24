package com.example.simbirsoftsummerworkshop.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simbirsoftsummerworkshop.R

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var avatarImageView: ImageView? = null
    var name: TextView? = null

    init {
        avatarImageView = itemView.findViewById(R.id.avatar_profile_image_view)
        name = itemView.findViewById(R.id.name_friend_text_view)
    }

}