package com.example.socialapp_mvvm_di.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.socialapp_mvvm_di.R
import com.example.socialapp_mvvm_di.databinding.ActivityCommentsBinding
import com.example.socialapp_mvvm_di.databinding.ActivityMainBinding
import com.example.socialapp_mvvm_di.viewmodels.viewmodels.PostsViewModel

class CommentsActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}