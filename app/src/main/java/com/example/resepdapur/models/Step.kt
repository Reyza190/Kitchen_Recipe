package com.example.resepdapur.models

import com.google.gson.annotations.SerializedName

data class Step(
    @SerializedName("number")
    val number: String,

    @SerializedName("description")
    val description: String
)
