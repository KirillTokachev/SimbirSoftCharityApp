package com.example.simbirsoftsummerworkshop.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.data.Person

class FriendsAdapter(private val friends: List<Person>) : RecyclerView.Adapter<FriendsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.friends_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.avatarImageView?.setImageResource(friends[position].avatarId)
        holder.name?.text = friends[position].name
    }

    override fun getItemCount(): Int {
        return friends.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var avatarImageView: ImageView? = null
        var name: TextView? = null

        init {
            avatarImageView = itemView.findViewById(R.id.avatar_profile_image_view)
            name = itemView.findViewById(R.id.name_friend_text_view)
        }
    }
}
