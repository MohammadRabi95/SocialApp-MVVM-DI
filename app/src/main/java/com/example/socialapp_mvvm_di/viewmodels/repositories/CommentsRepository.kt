package com.example.socialapp_mvvm_di.viewmodels.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.socialapp_mvvm_di.di.ApiService
import com.example.socialapp_mvvm_di.models.Comments
import javax.inject.Inject

class CommentsRepository @Inject constructor(
    private val apiService: ApiService,
    private val postId: Int) {

    private val commentsLiveData = MutableLiveData<List<Comments>>()

    val allComments: LiveData<List<Comments>>
        get() = commentsLiveData


    suspend fun getComments() {
        val result = apiService.getCommentsByPost(postId)
        if (result.isSuccessful && result.body() != null) {
            commentsLiveData.postValue(result.body())
        }
    }
}

