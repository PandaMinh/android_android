package com.example.demokotlin.posts

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {
    private val gson = Gson().newBuilder().create()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
    .build()

    val authService = retrofit.create(AuthService::class.java)

}