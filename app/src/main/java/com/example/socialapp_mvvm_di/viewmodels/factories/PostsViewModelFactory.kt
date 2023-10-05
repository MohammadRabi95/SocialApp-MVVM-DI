package com.example.socialapp_mvvm_di.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.socialapp_mvvm_di.viewmodels.repositories.PostsRepository
import com.example.socialapp_mvvm_di.viewmodels.viewmodels.PostsViewModel
import javax.inject.Inject

class PostsViewModelFactory @Inject constructor(val postsRepository: PostsRepository, val userId: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostsViewModel(postsRepository) as T
    }
}