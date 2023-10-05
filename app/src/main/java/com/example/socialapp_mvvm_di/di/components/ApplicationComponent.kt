package com.example.socialapp_mvvm_di.di.components

import com.example.socialapp_mvvm_di.di.modules.NetworkModule
import com.example.socialapp_mvvm_di.views.MainActivity
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun getPostsComponentFactory() : PostsComponent.MyFactory
}