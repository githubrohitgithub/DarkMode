package com.example.registerlogin.api

import com.example.registerlogin.model.ExampleJson2KtKotlin
import retrofit2.http.*

interface RetroService {
    @POST("login")
    @FormUrlEncoded
    fun login(@Field("email") email: String,
              @Field("password") password: String):retrofit2.Call<ExampleJson2KtKotlin>
}