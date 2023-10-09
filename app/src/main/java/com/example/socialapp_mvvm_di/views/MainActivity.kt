package com.example.socialapp_mvvm_di.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.socialapp_mvvm_di.MyApplication
import com.example.socialapp_mvvm_di.databinding.ActivityMainBinding
import com.example.socialapp_mvvm_di.models.Posts
import com.example.socialapp_mvvm_di.utils.Constants.showToast
import com.example.socialapp_mvvm_di.utils.Constants.toNextActivity
import com.example.socialapp_mvvm_di.viewmodels.ViewModelFactory
import com.example.socialapp_mvvm_di.viewmodels.viewmodels.PostsViewModel
import com.example.socialapp_mvvm_di.views.adapters.PostsAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity(), PostsAdapter.PostClickListener {

    @Inject
    lateinit var postsViewModelFactory: ViewModelFactory
    lateinit var binding: ActivityMainBinding

    lateinit var postsViewModel: PostsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val appComponent = (application as MyApplication).applicationComponent
        val postsComponent = appComponent.getPostsComponentFactory().create(2)
        postsComponent.inject(this)
        postsViewModel = ViewModelProvider(this, postsViewModelFactory)[PostsViewModel::class.java]

        postsViewModel.allPosts.observe(this) {
            binding.postRv.adapter = PostsAdapter(it, this)
        }
    }

    override fun onClick(posts: Posts, type: PostsAdapter.ClickType) {
        when (type) {
            PostsAdapter.ClickType.like -> showToast("like", this)
            PostsAdapter.ClickType.comment -> toNextActivity(this, CommentsActivity::class.java
            ,"postId", posts.id.toString())
            PostsAdapter.ClickType.share -> showToast("share", this)
        }
    }


}