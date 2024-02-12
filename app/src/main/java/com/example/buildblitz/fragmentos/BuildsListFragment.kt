package com.example.buildblitz.fragmentos

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.buildblitz.adapters.BuildsListAdapter
import com.example.buildblitz.databinding.FragmentItemListBinding
import com.example.buildblitz.databinding.ItemBuildBinding
import com.example.buildblitz.item.Builds
import com.example.buildblitz.item.BuildsProvider

open class BuildsListFragment: Fragment() {
    private lateinit var binding: FragmentItemListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listaBuilds = BuildsProvider.listaItem
        iniciarRecyclerView(listaBuilds)
    }
    public fun iniciarRecyclerView(listDietas:List<Builds>) {
        val manager = LinearLayoutManager(requireActivity())
        binding.RecyclerBuilds.layoutManager = manager
        binding.RecyclerBuilds.adapter =
            BuildsListAdapter(BuildsProvider.listaItem) { onItemSelected(it) }
    }

    private fun onItemSelected(item: Build) {

    }

}