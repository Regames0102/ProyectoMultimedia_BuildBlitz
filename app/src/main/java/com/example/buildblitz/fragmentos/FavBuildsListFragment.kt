package com.example.buildblitz.fragmentos

import android.os.Bundle
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
        iniciarRecyclerView(listaBuildsFavoritas)
    }
    fun obtenerBuildsFavoritas() :List<Builds>{
        return BuildsProvider.listaItem.filter { it.esFavorita }
    }
}