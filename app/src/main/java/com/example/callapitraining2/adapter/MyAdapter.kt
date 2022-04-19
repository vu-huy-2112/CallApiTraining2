package com.example.callapitraining2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.viewmodel.savedstate.R
import androidx.recyclerview.widget.RecyclerView
import com.example.callapitraining2.model.UsersItem

class MyAdapter(val context:Context, val userList:List<UsersItem>) : RecyclerView.Adapter<MyAdapter.ViewHoder>() {



    class ViewHoder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var name : TextView
        var email : TextView
        var status : TextView
        var gender :TextView

        init {
            name = itemView.findViewById(com.example.callapitraining2.R.id.tvName)
            email = itemView.findViewById(com.example.callapitraining2.R.id.tvEmail)
            status = itemView.findViewById(com.example.callapitraining2.R.id.tvStatus)
            gender = itemView.findViewById(com.example.callapitraining2.R.id.tvGender)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoder {
        var itemView = LayoutInflater.from(context).inflate(com.example.callapitraining2.R.layout.row_items, parent, false)
        return ViewHoder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHoder, position: Int) {
        holder.name.text = userList[position].name.toString()
        holder.email.text = userList[position].email.toString()
        holder.gender.text = userList[position].gender.toString()
        holder.status.text = userList[position].status.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}