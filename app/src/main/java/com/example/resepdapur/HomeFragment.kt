package com.example.resepdapur

import android.content.Intent
import android.content.Intent.getIntent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.resepdapur.Adapter.AdapterlistItem
import com.example.resepdapur.`interface`.RetrofitClient
import com.example.resepdapur.`interface`.TokenResponse
import com.example.resepdapur.models.Recipe
import com.example.resepdapur.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList


class HomeFragment : Fragment() {

    private lateinit var rvItem: RecyclerView
    private val recipeArrayList = ArrayList<Recipe>()
    private var recyclerView: RecyclerView? = null
    private lateinit var userImageView: ImageView
    private lateinit var tvUser: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvItem = view.findViewById(R.id.rvItem)
        userImageView = view.findViewById(R.id.ivUser)
        tvUser = view.findViewById(R.id.tvUser)
        tvUser.text = getString(R.string.name)

        showData()


    }

    private fun showData() {
        recipeArrayList.addAll(Data.getAllData())
        rvItem.layoutManager = LinearLayoutManager(context)
        rvItem.adapter = AdapterlistItem(recipeArrayList)
        recyclerView?.adapter = rvItem.adapter
    }


    private fun showdata() {
        RetrofitClient.instance.getAllRecipe()
            .enqueue(object : Callback<com.example.resepdapur.`interface`.RecipeResponse> {
                override fun onResponse(
                    call: Call<com.example.resepdapur.`interface`.RecipeResponse>,
                    response: Response<com.example.resepdapur.`interface`.RecipeResponse>
                ) {
                    recipeArrayList.addAll(response.body()!!.recipes)
                    rvItem.layoutManager = LinearLayoutManager(context)
                    rvItem.adapter = AdapterlistItem(recipeArrayList)
                }

                override fun onFailure(
                    call: Call<com.example.resepdapur.`interface`.RecipeResponse>,
                    t: Throwable
                ) {
                    Toast.makeText(context, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

            })
    }
}


