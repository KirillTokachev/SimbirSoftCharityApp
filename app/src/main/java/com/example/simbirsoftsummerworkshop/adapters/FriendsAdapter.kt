package com.example.simbirsoftsummerworkshop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.data.User

class FriendsAdapter(private val friends: List<User>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.friends_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.avatarImageView?.let {
            Glide.with(holder.itemView)
                .load(friends[position].avatar)
                .placeholder(R.drawable.avatar)
                .into(it)
        }
        holder.name?.text = friends[position].name
    }

    override fun getItemCount(): Int {
        return friends.size
    }
}
