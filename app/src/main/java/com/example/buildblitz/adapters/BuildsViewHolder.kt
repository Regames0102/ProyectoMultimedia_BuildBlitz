package com.example.buildblitz.adapters

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.buildblitz.R
import com.example.buildblitz.databinding.ItemBuildBinding
import com.example.buildblitz.item.Builds

class BuildsViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val binding = ItemBuildBinding.bind(view)
    fun render(buildmodel: Builds, onClickListener: (Builds) -> Unit){
        binding.TVUser.text=buildmodel.usuario
        binding.tvPersonaje.text=buildmodel.personaje
        Glide.with(binding.ivBuild.context).load(buildmodel.build).into(binding.ivBuild)
        itemView.setOnClickListener{onClickListener(buildmodel)}
        val favoritosAdapter = FavBuildsListAdapter()

        binding.btnFav.setOnClickListener{
            buildmodel.esFavorita=true;
        }

    }
}