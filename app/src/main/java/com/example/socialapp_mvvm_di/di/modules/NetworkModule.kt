package com.example.socialapp_mvvm_di.di.modules

import com.example.socialapp_mvvm_di.di.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {

    private const val baseUrl = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }
}