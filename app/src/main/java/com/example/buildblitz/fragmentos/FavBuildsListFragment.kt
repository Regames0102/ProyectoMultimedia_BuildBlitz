package com.example.buildblitz.fragmentos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.buildblitz.R
import com.example.buildblitz.item.Builds
import com.example.buildblitz.item.BuildsProvider

class FavBuildsListFragment : BuildsListFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listaBuildsFavoritas = obtenerBuildsFavoritas()
        Log.d("Dani", obtenerBuildsFavoritas().toString())
        iniciarRecyclerView(listaBuildsFavoritas)
    }
    fun obtenerBuildsFavoritas() : MutableList<Builds>{
        return BuildsProvider.listaItem.filter { it.esFavorita }.toMutableList()
    }

}