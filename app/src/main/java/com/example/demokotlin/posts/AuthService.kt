package com.example.demokotlin.posts

import retrofit2.http.GET
import retrofit2.http.POST

interface AuthService {
    @GET("posts")
    suspend fun getListPosts(): ListPosts
}