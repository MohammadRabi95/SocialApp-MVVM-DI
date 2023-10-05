package com.example.socialapp_mvvm_di.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.socialapp_mvvm_di.R
import com.example.socialapp_mvvm_di.models.Posts

class PostsAdapter(private val list: List<Posts>,val postClickListener: PostClickListener) : RecyclerView.Adapter<PostsAdapter.PostsHolder>() {

    enum class ClickType{
        like, comment, share
    }
    class PostsHolder(itemView: View) : ViewHolder(itemView) {
        val title_tv = itemView.findViewById<TextView>(R.id.title_tv)
        val body_tv = itemView.findViewById<TextView>(R.id.body_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsHolder {
        return PostsHolder(LayoutInflater.from(parent.context).inflate(R.layout.posts_row, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PostsHolder, position: Int) {
        val posts = list[position]
        if (posts != null) {
            holder.title_tv.text = posts.title
            holder.body_tv.text = posts.body

            holder.itemView.setOnClickListener {
                when (it.id) {
                    R.id.btn_like -> postClickListener.onClick(posts, type = ClickType.like)
                    R.id.btn_cmnt -> postClickListener.onClick(posts, type = ClickType.comment)
                    R.id.btn_share -> postClickListener.onClick(posts, type = ClickType.share)
                }
            }
        }
    }

    interface PostClickListener {
        fun onClick(posts: Posts, type: ClickType)
    }
}