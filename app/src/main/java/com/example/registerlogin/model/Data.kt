package com.example.registerlogin.model

import com.google.gson.annotations.SerializedName

data class Data (
    @SerializedName("email"            ) var id           : String?    = null,
    @SerializedName("password"          ) var name         : String? = null
    )


