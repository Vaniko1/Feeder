package com.example.spoty.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.spoty.R
import com.example.spoty.model.UserInfo
import com.google.android.material.imageview.ShapeableImageView

class RecyclerViewPostAdapter(private val newsList: ArrayList<UserInfo>)
        : RecyclerView.Adapter<RecyclerViewPostAdapter.MyViewHolder>() {

        class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

            val tvHeading : TextView = itemView.findViewById(R.id.tvHeading)
            val tvHeadingTwo : TextView = itemView.findViewById(R.id.tvHeadingTwo)

            fun setData(Feed: UserInfo){
                tvHeading.text = Feed.SongName
                tvHeadingTwo.text = Feed.FeedBack
            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
            parent, false)
            return MyViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val currentItem = newsList[position]
            holder.setData(currentItem)
        }

        override fun getItemCount() = newsList.size
}