package com.example.buildblitz.adapters

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.buildblitz.R
import com.example.buildblitz.item.Builds

class BuildsListAdapter(private val ListaBuilds: List<Builds>, private val onClickListener: (Build) -> Unit) : RecyclerView.Adapter<BuildsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuildsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_build,parent,false)
        return BuildsViewHolder(view)
    }

    override fun getItemCount(): Int =ListaBuilds.size

    override fun onBindViewHolder(holder: BuildsViewHolder, position: Int) {
        holder.render(ListaBuilds[position], onClickListener)
        holder.binding.btnFav.setOnClickListener(){
            ListaBuilds[position].esFavorita = true
            notifyDataSetChanged()
        }
    }
}