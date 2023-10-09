package com.example.socialapp_mvvm_di.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.socialapp_mvvm_di.R
import com.example.socialapp_mvvm_di.models.Comments

class CommentsAdapter (private val list: List<Comments>) :
    RecyclerView.Adapter<CommentsAdapter.CommentsHolder>() {



    class CommentsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title_tv = itemView.findViewById<TextView>(R.id.cmnt_nam_cmntrow)
        val body_tv = itemView.findViewById<TextView>(R.id.cmnt_bdy_cmntrow)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsHolder {
        return CommentsHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.comments_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CommentsHolder, position: Int) {
        val comments = list[position]
        holder.title_tv.text = comments.name
        holder.body_tv.text = comments.body

    }

}