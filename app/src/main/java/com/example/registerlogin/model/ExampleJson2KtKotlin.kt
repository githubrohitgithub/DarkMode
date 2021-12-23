package com.example.registerlogin.model

import com.google.gson.annotations.SerializedName

data class ExampleJson2KtKotlin (val error: Boolean,

                                 val message:String,

                                 @SerializedName("token" ) var token : Boolean? = null

                                )