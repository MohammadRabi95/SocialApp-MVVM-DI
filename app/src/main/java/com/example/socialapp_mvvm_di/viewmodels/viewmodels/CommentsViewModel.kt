package com.example.socialapp_mvvm_di.viewmodels.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialapp_mvvm_di.models.Comments
import com.example.socialapp_mvvm_di.viewmodels.repositories.CommentsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CommentsViewModel
@Inject constructor(val commentsRepository: CommentsRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            commentsRepository.getComments()
        }
    }

    val allComments: LiveData<List<Comments>>
        get() = commentsRepository.allComments

}