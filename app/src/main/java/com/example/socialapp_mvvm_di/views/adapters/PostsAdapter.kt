package com.example.socialapp_mvvm_di.views.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.socialapp_mvvm_di.R
import com.example.socialapp_mvvm_di.models.Posts

class PostsAdapter(private val list: List<Posts>, val postClickListener: PostClickListener) :
    RecyclerView.Adapter<PostsAdapter.PostsHolder>() {


    enum class ClickType {
        like, comment, share
    }

    class PostsHolder(itemView: View) : ViewHolder(itemView) {
        val title_tv = itemView.findViewById<TextView>(R.id.title_tv)
        val body_tv = itemView.findViewById<TextView>(R.id.body_tv)

        val like_btn = itemView.findViewById<TextView>(R.id.btn_like)
        val cmnt_btn = itemView.findViewById<TextView>(R.id.btn_cmnt)
        val share_btn = itemView.findViewById<TextView>(R.id.btn_share)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsHolder {
        return PostsHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.posts_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PostsHolder, position: Int) {
        val posts = list[position]
            holder.title_tv.text = posts.title
            holder.body_tv.text = posts.body

            holder.like_btn.setOnClickListener {
                postClickListener.onClick(posts, type = ClickType.like)
            }
            holder.cmnt_btn.setOnClickListener {
                postClickListener.onClick(posts, type = ClickType.comment)
            }
            holder.share_btn.setOnClickListener {
                postClickListener.onClick(posts, type = ClickType.share)
            }
    }

    interface PostClickListener {
        fun onClick(posts: Posts, type: ClickType)
    }
}