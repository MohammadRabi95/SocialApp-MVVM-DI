package com.example.socialapp_mvvm_di.di.components

import com.example.socialapp_mvvm_di.di.modules.NetworkModule
import com.example.socialapp_mvvm_di.di.modules.PostsModule
import com.example.socialapp_mvvm_di.views.MainActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

@Subcomponent(modules = [PostsModule::class])
interface PostsComponent {

    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface MyFactory {
        fun create(@BindsInstance userId: Int) : PostsComponent
    }
}