package com.example.resepdapur.`interface`

import com.example.resepdapur.models.Recipe
import com.google.gson.annotations.SerializedName

data class RecipeResponse(
    @SerializedName("recipes")
    val recipes: List<Recipe>
)
