package com.example.socialapp_mvvm_di.di.modules

import androidx.lifecycle.ViewModel
import com.example.socialapp_mvvm_di.viewmodels.viewmodels.CommentsViewModel
import com.example.socialapp_mvvm_di.viewmodels.viewmodels.PostsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

    @ClassKey(PostsViewModel::class)
    @IntoMap
    @Binds
    abstract fun getPostsViewModel(postsViewModel: PostsViewModel) : ViewModel

    @ClassKey(CommentsViewModel::class)
    @IntoMap
    @Binds
    abstract fun getCommentsViewModel(commentsViewModel: CommentsViewModel) : ViewModel
}