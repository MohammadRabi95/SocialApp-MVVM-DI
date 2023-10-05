package com.example.socialapp_mvvm_di

import android.app.Application
import com.example.socialapp_mvvm_di.di.components.ApplicationComponent
import com.example.socialapp_mvvm_di.di.components.DaggerApplicationComponent
import com.example.socialapp_mvvm_di.di.components.PostsComponent

class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.create()
    }
}