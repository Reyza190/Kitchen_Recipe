package com.example.resepdapur.models

import com.google.gson.annotations.SerializedName

data class Pagination(
    @SerializedName("totalPage")
    val totalPage: Int,
    @SerializedName("currentPage")
    val currentPage: Int
)
