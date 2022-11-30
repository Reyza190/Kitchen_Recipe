package com.example.resepdapur.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.resepdapur.DetailActivity
import com.example.resepdapur.R
import com.example.resepdapur.models.Recipe

class AdapterlistItem(private val mlist: List<Recipe>) : RecyclerView.Adapter<AdapterlistItem.ViewHolder>() {

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        val foodImage : ImageView = itemView.findViewById(R.id.foodImage)
        val foodName : TextView = itemView.findViewById(R.id.foodName)
        val desc : TextView = itemView.findViewById(R.id.desc)
        val cvCardItem: ConstraintLayout = itemView.findViewById(R.id.cvCardItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemViewModel = mlist[position]
        Glide.with(holder.itemView.context).load(itemViewModel.img_id).into(holder.foodImage)
        holder.foodName.text = itemViewModel.title
        holder.desc.text = itemViewModel.description
        holder.cvCardItem.setOnClickListener{
            val intent: Intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("DATA", itemViewModel.id)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return mlist.size
    }
}