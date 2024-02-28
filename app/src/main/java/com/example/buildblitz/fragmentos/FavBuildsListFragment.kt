package com.example.buildblitz.fragmentos

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.buildblitz.R
import com.example.buildblitz.adapters.BuildsListAdapter
import com.example.buildblitz.databinding.FragmentFavItemListBinding
import com.example.buildblitz.item.Builds
import com.example.buildblitz.item.BuildsProvider

class FavBuildsListFragment : Fragment() {

    private lateinit var binding: FragmentFavItemListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavItemListBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listaBuildsFavoritas = obtenerBuildsFavoritas()
        Log.d("Dani", obtenerBuildsFavoritas().toString())
        iniciarFavRecyclerView(listaBuildsFavoritas)
    }
    fun obtenerBuildsFavoritas() : MutableList<Int>{
        return BuildsProvider.ListaFavBuilds
    }

    fun iniciarFavRecyclerView(listBuilds:  MutableList<Int>) {
        val manager = LinearLayoutManager(requireActivity())
        val favBuilds = BuildsProvider.listaItem.filter{ builds -> listBuilds.contains(builds.id)}.toMutableList()
        binding.RecyclerFavBuilds.layoutManager = manager
        binding.RecyclerFavBuilds.adapter = BuildsListAdapter(favBuilds) { onFavItemSelected(it) }
    }

    override fun onResume() {
        super.onResume()
        val favListBuild = obtenerBuildsFavoritas()
        iniciarFavRecyclerView(favListBuild)
    }
    private fun onFavItemSelected(item: Builds) {
        val bundle = Bundle()
        bundle.putParcelable("build",item)
        findNavController().navigate(R.id.action_menuFragment_to_detailBuildsFragment,bundle)
    }

}