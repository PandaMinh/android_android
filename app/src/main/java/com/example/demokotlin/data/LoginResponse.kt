package com.example.demokotlin.data


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("data")
    val data: Data,
    @SerializedName("status")
    val status: Int,
    @SerializedName("status_message")
    val statusMessage: String,
    @SerializedName("timestamp")
    val timestamp: String
){

    data class Data(
        @SerializedName("access_token")
        val accessToken: String,
        @SerializedName("access_token_life_time")
        val accessTokenLifeTime: Int,
        @SerializedName("refresh_token")
        val refreshToken: String,
        @SerializedName("refresh_token_life_time")
        val refreshTokenLifeTime: Int,
        @SerializedName("token_type")
        val tokenType: String
    )
}