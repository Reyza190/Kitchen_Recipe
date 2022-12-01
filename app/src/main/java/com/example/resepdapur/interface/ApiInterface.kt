package com.example.resepdapur.`interface`



import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path


interface ApiInterface {
    @GET("api/recipe")
    fun getAllRecipe(): retrofit2.Call<RecipeResponse>

    @GET("api/recipe/{id}")
    fun getRecipebyId(
        @Path("id")id: Int
    ):retrofit2.Call<RecipebyIdResponse>

    @POST("api/login")
    fun login(
        @Body loginRequest: LoginRequest
    ): retrofit2.Call<LoginResponse>

    @POST("api/register")
    fun regis(
        @Body regisRequest: RegisRequest
    ): retrofit2.Call<LoginResponse>

    @GET("api/me")
    fun getUser(@Header("Authorization")token: String):Call<>
}