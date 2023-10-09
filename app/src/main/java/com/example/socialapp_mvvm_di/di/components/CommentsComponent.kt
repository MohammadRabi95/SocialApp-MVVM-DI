package com.example.socialapp_mvvm_di.di.components


import com.example.socialapp_mvvm_di.di.annotations.ActivityScope
import com.example.socialapp_mvvm_di.di.modules.CommentsModule

import com.example.socialapp_mvvm_di.views.CommentsActivity
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [CommentsModule::class])
interface CommentsComponent {

    fun inject(commentsActivity: CommentsActivity)

    @Subcomponent.Factory
    interface CommentsFactory {
        fun create(@BindsInstance postId: Int) : CommentsComponent
    }
}