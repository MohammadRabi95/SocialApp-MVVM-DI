package com.example.socialapp_mvvm_di.di.modules

import com.example.socialapp_mvvm_di.di.ApiService
import com.example.socialapp_mvvm_di.viewmodels.repositories.CommentsRepository
import dagger.Module
import dagger.Provides
@Module
class CommentsModule {

    @Provides
    fun provideCommentsRepository(apiService: ApiService, postId: Int) : CommentsRepository {
        return CommentsRepository(apiService, postId)
    }
}