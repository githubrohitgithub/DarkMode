package com.example.registerlogin.model

import com.google.gson.annotations.SerializedName

data class RegisterResponse (val error: Boolean,

                             val message:String,
    @SerializedName("id"    ) var id    : Int?    = null,
    @SerializedName("token" ) var token : Boolean? = null
    )