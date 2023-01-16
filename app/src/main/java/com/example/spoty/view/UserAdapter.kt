package com.example.spoty.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.spoty.R
import com.example.spoty.model.UserInfo

class UserAdapter(val c: Context,val userList:ArrayList<UserInfo>):RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.tvHeading)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val infalter = LayoutInflater.from(parent.context)
        val itemView = infalter.inflate(R.layout.list_item,parent,false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val newList = userList[position]
        holder.name.text = newList.SongName
        holder.name.text = newList.FeedBack
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}