package com.example.socialapp_mvvm_di.viewmodels.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialapp_mvvm_di.models.Posts
import com.example.socialapp_mvvm_di.viewmodels.repositories.PostsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class PostsViewModel (val postsRepository: PostsRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            postsRepository.getAllPosts()
        }
        viewModelScope.launch(Dispatchers.IO) {
            postsRepository.getPostsByUserId()
        }
    }

    val allPosts: LiveData<List<Posts>>
        get() = postsRepository.allPosts

    val userPosts: LiveData<List<Posts>>
        get() = postsRepository.userPosts
}