package com.example.resepdapur

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.resepdapur.Adapter.AdapterDetail
import com.example.resepdapur.Adapter.AdapterlistItem
import com.example.resepdapur.`interface`.RecipeResponse
import com.example.resepdapur.`interface`.RecipebyIdResponse
import com.example.resepdapur.`interface`.RetrofitClient
import com.example.resepdapur.models.Recipe
import com.example.resepdapur.models.Step
import de.hdodenhof.circleimageview.CircleImageView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    private lateinit var cvImage: CircleImageView
    private lateinit var tvDesription : TextView
    private lateinit var tvJudul: TextView
    private val steps = ArrayList<Step>()
    private val recipes = ArrayList<Recipe>()
    private var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        init()
        val id: Int = intent.getIntExtra("DATA", 0)
        showDataDetail(id)

    }

    private fun showDataDetail(id : Int) {
//        recipes.addAll(RetrofitClient.instance.getRecipebyId(id).body()!!.recipes)

        RetrofitClient.instance.getRecipebyId(id).enqueue(object : Callback<RecipebyIdResponse>{
            override fun onResponse(
                call: Call<RecipebyIdResponse>,
                response: Response<RecipebyIdResponse>
            ) {
                recipes.addAll(listOf(response.body()!!.recipe))
                steps.addAll(response.body()!!.steps)
                setData(recipes, steps)
            }

            override fun onFailure(call: Call<RecipebyIdResponse>, t: Throwable) {
                Toast.makeText(this@DetailActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })

//        RetrofitClient.instance.getRecipebyId(id).enqueue(object : Callback<RecipeResponse>{
//            override fun onResponse(
//                call: Call<RecipeResponse>,
//                response: Response<RecipeResponse>
//            ) {
//                if (response.isSuccessful){
//                    Toast.makeText(applicationContext, "gagal", Toast.LENGTH_SHORT).show()
//                    if (response.body() != null){
//                        Toast.makeText(applicationContext, "0", Toast.LENGTH_SHORT).show()
//                    }
//                }
////                recipes.addAll(response.body()!!.recipes)
//            }
//
//            override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {
//                Log.e(t.toString(), "error")
//                Toast.makeText(this@DetailActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
//            }
//
//        })
//        RetrofitClient.instance.getRecipebyId(id).enqueue(object : Callback<RecipeResponse>{
//            override fun onResponse(
//                call: Call<RecipeResponse>,
//                response: Response<RecipeResponse>
//            ) {
//                recipes.addAll(response.body()!!.recipes)
//            }
//
//            override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {
//                Toast.makeText(this@DetailActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
//            }
//
//        })
    }

    @SuppressLint("CheckResult")
    private fun setData(recipes : ArrayList<Recipe>, steps : ArrayList<Step>){
        Glide.with(this).load(recipes.get(0).img_id).into(cvImage)
        tvJudul.text = recipes.get(0).title
        tvDesription.text = recipes.get(0).description
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.adapter = AdapterDetail(steps)
    }

    private fun init(){
        cvImage = findViewById(R.id.circleImageView)
        tvJudul = findViewById(R.id.tvjuduldetail)
        tvDesription = findViewById(R.id.tvDescriptionDetail)
        recyclerView = findViewById(R.id.rvDetail)
    }
}