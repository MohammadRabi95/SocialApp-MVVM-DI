package com.example.socialapp_mvvm_di.models

data class Todos(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)