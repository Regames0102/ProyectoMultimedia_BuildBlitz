package com.example.buildblitz.adapters

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.buildblitz.R
import com.example.buildblitz.databinding.ItemBuildBinding
import com.example.buildblitz.item.Builds
import com.example.buildblitz.item.BuildsProvider

class BuildsViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val binding = ItemBuildBinding.bind(view)
    fun render(buildmodel: Builds, onClickListener: (Builds) -> Unit){
        binding.TVUser.text=buildmodel.usuario
        binding.tvPersonaje.text=buildmodel.personaje
        Glide.with(binding.ivBuild.context).load(buildmodel.build).into(binding.ivBuild)
        itemView.setOnClickListener{onClickListener(buildmodel)}

        binding.btnFav.setOnClickListener{
            val isFav = BuildsProvider.ListaFavBuilds.contains(buildmodel.id)
            if (isFav){
                BuildsProvider.ListaFavBuilds.remove(buildmodel.id)
                showToast("Eliminado")
            }
            else{
                BuildsProvider.ListaFavBuilds.add(buildmodel.id)
                showToast("Añadido")
            }
        }

    }
    private fun showToast(message: String) {
        Toast.makeText(itemView.context, message, Toast.LENGTH_SHORT).show()
    }
}