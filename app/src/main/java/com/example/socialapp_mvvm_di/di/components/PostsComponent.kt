package com.example.socialapp_mvvm_di.di.components

import com.example.socialapp_mvvm_di.di.annotations.ActivityScope
import com.example.socialapp_mvvm_di.di.modules.PostsModule
import com.example.socialapp_mvvm_di.views.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [PostsModule::class])
interface PostsComponent {

    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface PostsFactory {
        fun create(@BindsInstance userId: Int) : PostsComponent
    }
}