package com.example.resepdapur.`interface`

data class LoginResponse(
    val access_token: String,
    val token_type: String,
    val expires_in: Int
)
