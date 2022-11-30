package com.example.resepdapur.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.resepdapur.R
import com.example.resepdapur.models.Step

class AdapterDetail(private val recipes: List<Step>): RecyclerView.Adapter<AdapterDetail.ViewHolder>() {
    class ViewHolder(ItemView : View) : RecyclerView.ViewHolder(ItemView) {
        val number: TextView = itemView.findViewById(R.id.stepNumber)
        val descriptionDetail : TextView = itemView.findViewById(R.id.stepDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_detail, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val step = recipes[position]
        holder.number.text = "Step " + step.number
        holder.descriptionDetail.text = step.description
    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}