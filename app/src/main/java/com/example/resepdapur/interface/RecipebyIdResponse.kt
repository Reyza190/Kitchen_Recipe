package com.example.resepdapur.`interface`

import com.example.resepdapur.models.Recipe
import com.example.resepdapur.models.Step
import com.google.gson.annotations.SerializedName

data class RecipebyIdResponse(
    @SerializedName("recipe")
    val recipe: Recipe,

    @SerializedName("steps")
    val steps: List<Step>
)
