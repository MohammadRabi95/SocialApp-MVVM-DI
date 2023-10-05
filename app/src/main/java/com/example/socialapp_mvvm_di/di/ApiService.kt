package com.example.socialapp_mvvm_di.di

import com.example.socialapp_mvvm_di.models.Albums
import com.example.socialapp_mvvm_di.models.Comments
import com.example.socialapp_mvvm_di.models.Photos
import com.example.socialapp_mvvm_di.models.Posts
import com.example.socialapp_mvvm_di.models.Users
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("posts")
    suspend fun getPosts(): Response<List<Posts>>

    @GET("posts")
    suspend fun getPostsByUserId(@Query("userId") userId: Int): Response<List<Posts>>

    @GET("comments")
    suspend fun getCommentsByPost(@Query("postId") postId: Int): Response<List<Comments>>

    @GET("users")
    suspend fun getAllUsers(): Response<List<Users>>

    @GET("users")
    suspend fun getUsersByEmail(@Query("email") email: String): Users

    @GET("albums")
    suspend fun getAlbumsByUserId(@Query("userId") userId: Int): Response<List<Albums>>

    @GET("photos")
    suspend fun getPhotosByAlbumId(@Query("albumId") albumId: Int): Response<List<Photos>>



}