package com.example.simbirsoftsummerworkshop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.data.CharitableFoundation

class NkoAdapter(private val nko: List<CharitableFoundation>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.nko_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameNko?.text = nko[position].name
    }

    override fun getItemCount(): Int {
        return nko.size
    }
}
