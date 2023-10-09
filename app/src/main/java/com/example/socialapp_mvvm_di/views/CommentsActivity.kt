package com.example.socialapp_mvvm_di.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.socialapp_mvvm_di.MyApplication
import com.example.socialapp_mvvm_di.databinding.ActivityCommentsBinding
import com.example.socialapp_mvvm_di.viewmodels.ViewModelFactory
import com.example.socialapp_mvvm_di.viewmodels.viewmodels.CommentsViewModel
import com.example.socialapp_mvvm_di.views.adapters.CommentsAdapter
import javax.inject.Inject

class CommentsActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommentsBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var commentsViewModel: CommentsViewModel
    var postId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        postId = intent.getStringExtra("postId")!!.toInt()

        val appComponent = (application as MyApplication).applicationComponent
        val commentsComponent = appComponent.getCommentsComponentFactory().create(postId)
        commentsComponent.inject(this)
        commentsViewModel = ViewModelProvider(this, viewModelFactory)[CommentsViewModel::class.java]

        commentsViewModel.allComments.observe(this) {
            binding.commentsRv.adapter = CommentsAdapter(it)
        }
    }
}