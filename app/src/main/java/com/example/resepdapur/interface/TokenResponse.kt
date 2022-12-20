package com.example.resepdapur.`interface`

import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String
)
