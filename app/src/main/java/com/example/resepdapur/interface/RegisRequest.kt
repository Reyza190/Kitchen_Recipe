package com.example.resepdapur.`interface`

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RegisRequest(
    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("email")
    @Expose
    var email: String,

    @SerializedName("password")
    @Expose
    val password: String
)
