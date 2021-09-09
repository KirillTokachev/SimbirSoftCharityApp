package com.example.simbirsoftsummerworkshop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.data.Help

class HelpAdapter(private val categoriesHelp: List<Help>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.help_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.apply {
            helpImageView?.let {
                Glide.with(holder.itemView)
                    .load(categoriesHelp[position].icon)
                    .placeholder(R.drawable.child)
                    .into(it)
            }
            helpTitleCategory?.text = categoriesHelp[position].title
        }
    }

    override fun getItemCount(): Int {
        return categoriesHelp.size
    }
}