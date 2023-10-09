package com.example.socialapp_mvvm_di.di.modules

import com.example.socialapp_mvvm_di.di.ApiService
import com.example.socialapp_mvvm_di.viewmodels.repositories.PostsRepository
import dagger.Module
import dagger.Provides

@Module
class PostsModule {

    @Provides
    fun providePostsRepository(apiService: ApiService, userId: Int) : PostsRepository{
        return PostsRepository(apiService, userId)
    }
}