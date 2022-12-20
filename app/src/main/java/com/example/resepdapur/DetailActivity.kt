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
    private lateinit var tvDesription: TextView
    private lateinit var tvJudul: TextView
    private val steps = ArrayList<Step>()
    private val recipes = ArrayList<Recipe>()
    private var recyclerView: RecyclerView? = null

    companion object {
        val key = "DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        init()
        val data = intent.getParcelableExtra<Recipe>(key)
        setData(data)

    }

    private fun setData(recipes: Recipe?) {
        Glide.with(this).load(recipes?.img_id).into(cvImage)
        tvDesription.text = recipes?.description
        tvJudul.text = recipes?.title

        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.adapter = AdapterDetail(Data.getSteps())
    }

    @SuppressLint("CheckResult")
    private fun setData(recipes: ArrayList<Recipe>, steps: ArrayList<Step>) {
        Glide.with(this).load(recipes.get(0).img_id).into(cvImage)
        tvJudul.text = recipes.get(0).title
        tvDesription.text = recipes.get(0).description
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.adapter = AdapterDetail(steps)
    }

    private fun init() {
        cvImage = findViewById(R.id.circleImageView)
        tvJudul = findViewById(R.id.tvjuduldetail)
        tvDesription = findViewById(R.id.tvDescriptionDetail)
        recyclerView = findViewById(R.id.rvDetail)
    }
}