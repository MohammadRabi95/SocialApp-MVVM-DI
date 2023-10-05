package com.example.socialapp_mvvm_di.viewmodels.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.socialapp_mvvm_di.di.ApiService
import com.example.socialapp_mvvm_di.models.Posts
import javax.inject.Inject

class PostsRepository @Inject constructor(private val apiService: ApiService,
                                          private var userId: Int) {

    private val postLiveData = MutableLiveData<List<Posts>>()
    private val userPostLiveData = MutableLiveData<List<Posts>>()

    val allPosts: LiveData<List<Posts>>
        get() = postLiveData

    val userPosts: LiveData<List<Posts>>
        get() = userPostLiveData

    suspend fun getAllPosts() {
        val result = apiService.getPosts()
        if (result.isSuccessful && result.body() != null) {
            postLiveData.postValue(result.body())
        }
    }

    suspend fun getPostsByUserId() {
        val result = apiService.getPostsByUserId(userId)
        if (result.isSuccessful && result.body() != null) {
            userPostLiveData.postValue(result.body())
        }
    }
}