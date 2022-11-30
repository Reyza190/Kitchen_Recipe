package com.example.resepdapur.models

import com.google.gson.annotations.SerializedName

data class Recipe(
    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("img_id")
    val img_id: String,

    @SerializedName("user_id")
    val user_id: Int,

    @SerializedName("description")
    val description: String,

    @SerializedName("user")
    val user: String,

    @SerializedName("views")
    val views: String
    )
