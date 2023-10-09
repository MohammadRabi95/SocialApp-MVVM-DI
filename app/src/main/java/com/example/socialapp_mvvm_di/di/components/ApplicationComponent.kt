package com.example.socialapp_mvvm_di.di.components


import com.example.socialapp_mvvm_di.di.modules.NetworkModule
import com.example.socialapp_mvvm_di.di.modules.ViewModelModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [
    NetworkModule::class,
    ViewModelModule::class])
interface ApplicationComponent {
    fun getPostsComponentFactory() : PostsComponent.PostsFactory

    fun getCommentsComponentFactory() : CommentsComponent.CommentsFactory
}