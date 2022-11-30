package com.example.resepdapur.repository

import com.example.resepdapur.models.Pagination
import com.example.resepdapur.models.Recipe
import com.google.gson.annotations.SerializedName

data class RecipeResponse(
    @SerializedName("Recipes")
    val recipes: List<Recipe>


//    @SerializedName("pagination")
//    val pagination: List<Pagination>? = null
)
