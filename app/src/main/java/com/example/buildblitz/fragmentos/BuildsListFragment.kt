package com.example.buildblitz.fragmentos

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.buildblitz.R
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
        iniciarRecyclerView(BuildsProvider.listaItem)
    }
    open fun iniciarRecyclerView(listBuilds:  MutableList<Builds>) {
        val manager = LinearLayoutManager(requireActivity())
        binding.RecyclerBuilds.layoutManager = manager
        binding.RecyclerBuilds.adapter = BuildsListAdapter(listBuilds) { onItemSelected(it) }

    }

    private fun onItemSelected(item: Builds) {
        val bundle = Bundle()
        bundle.putParcelable("build",item)
        findNavController().navigate(R.id.action_menuFragment_to_detailBuildsFragment,bundle)
    }
}