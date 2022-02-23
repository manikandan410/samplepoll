package com.example.poll

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyRoomAdapter(private val roomList : ArrayList<RoomUser>) : RecyclerView.Adapter<MyRoomAdapter
                                                                   .MyviewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.room_item,
        parent,false)
        return MyviewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        val currentitem = roomList[position]
        holder.title.text = currentitem.title
        holder.language.text = currentitem.language
        holder.handrise.text = currentitem.handrise
    }

    override fun getItemCount(): Int {
        return roomList.size
    }


    class MyviewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val title : TextView = itemView.findViewById(R.id.title)
        val language : TextView = itemView.findViewById(R.id.language)
        val handrise : TextView = itemView.findViewById(R.id.handrise)


    }
}