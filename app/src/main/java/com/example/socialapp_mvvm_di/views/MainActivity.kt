package com.example.socialapp_mvvm_di.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.socialapp_mvvm_di.MyApplication
import com.example.socialapp_mvvm_di.R
import com.example.socialapp_mvvm_di.databinding.ActivityMainBinding
import com.example.socialapp_mvvm_di.di.components.PostsComponent
import com.example.socialapp_mvvm_di.models.Posts
import com.example.socialapp_mvvm_di.viewmodels.factories.PostsViewModelFactory
import com.example.socialapp_mvvm_di.viewmodels.repositories.PostsRepository
import com.example.socialapp_mvvm_di.viewmodels.viewmodels.PostsViewModel
import com.example.socialapp_mvvm_di.views.adapters.PostsAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity(), PostsAdapter.PostClickListener {

    private val TAG = "MainActivity"

    @Inject
    lateinit var postsViewModelFactory: PostsViewModelFactory
    lateinit var binding: ActivityMainBinding

    lateinit var postsViewModel: PostsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val appComponent = (application as MyApplication).applicationComponent
        val postsComponent = appComponent.getPostsComponentFactory().create(1)
        postsComponent.inject(this)
        postsViewModel = ViewModelProvider(this, postsViewModelFactory)[PostsViewModel::class.java]

        binding.postRv.layoutManager = LinearLayoutManager(this)
        postsViewModel.userPosts.observe(this) {
            binding.postRv.adapter = PostsAdapter(it, this)
        }
    }

    override fun onClick(posts: Posts, type: PostsAdapter.ClickType) {
        when (type) {
            PostsAdapter.ClickType.like -> showToast("like")
            PostsAdapter.ClickType.comment -> showToast("comment")
            PostsAdapter.ClickType.share -> showToast("share")
        }
    }

    private fun showToast(msg : String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}