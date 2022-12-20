package com.example.resepdapur.`interface`
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient{
    private const val BASE_URL = "http://localhost:8000/"

//    var YOUR_TOKEN = ""
//
//    private var retrofit: Retrofit = Retrofit.Builder()
//        .baseUrl("BASE_URL")
//        .addConverterFactory(GsonConverterFactory.create())
//        .client(OkHttpClient.Builder().addInterceptor { chain ->
//            val request = chain.request().newBuilder().addHeader("Authorization", "Bearer ${YOUR_TOKEN}").build()
//            chain.proceed(request)
//        }.build())
//        .build()
//
//    var service: ApiInterface = retrofit.create(ApiInterface::class.java)

    val instance: ApiInterface by lazy {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiInterface::class.java)
    }
}