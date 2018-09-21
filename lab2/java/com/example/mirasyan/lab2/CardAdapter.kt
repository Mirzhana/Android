package com.example.mirasyan.lab2

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.card_item.view.*
import java.util.ArrayList

class UserAdapter(var context: Context, var dataset:ArrayList<User>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserViewHolder(LayoutInflater.from(context).inflate(R.layout.card_item, parent, false))
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var user = dataset[position]
        holder.itemView.user_name.text = user.name
        holder.itemView.user_info.text = user.info

    }
    inner class UserViewHolder(view:View): RecyclerView.ViewHolder(view)
}