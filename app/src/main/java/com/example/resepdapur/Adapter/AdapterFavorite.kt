package com.example.resepdapur.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.resepdapur.ItemViewModel
import com.example.resepdapur.R

class AdapterFavorite(private val mlist: List<ItemViewModel>) : RecyclerView.Adapter<AdapterFavorite.ViewHolder>() {
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        val foodImage : ImageView = itemView.findViewById(R.id.civFood)
        val foodName : TextView = itemView.findViewById(R.id.tvFavFood)
        val desc : TextView = itemView.findViewById(R.id.tvFavFoodDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mlist.size
    }

    override fun onBindViewHolder(holder: AdapterFavorite.ViewHolder, position: Int) {
        val itemViewModel = mlist[position]
        holder.foodImage.setImageResource(itemViewModel.image)
        holder.foodName.text = itemViewModel.foodName
        holder.desc.text = itemViewModel.desc
    }
}