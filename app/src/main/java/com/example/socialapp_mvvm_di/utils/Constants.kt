package com.example.socialapp_mvvm_di.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast

object Constants {

    const val baseUrl = "https://jsonplaceholder.typicode.com/"

    fun showToast(msg : String, ctx : Context) {
        Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show()
    }

    fun toNextActivity(from: Activity, to: Class<*>, key: String, data: String) {
        from.startActivity(Intent(from, to).putExtra(key, data))
    }
}