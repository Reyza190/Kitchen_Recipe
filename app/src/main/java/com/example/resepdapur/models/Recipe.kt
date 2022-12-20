package com.example.resepdapur.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
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
) : Parcelable
