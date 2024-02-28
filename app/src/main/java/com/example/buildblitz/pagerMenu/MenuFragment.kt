package com.example.buildblitz.pagerMenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.buildblitz.R
import com.example.buildblitz.databinding.FragmentMenuBinding
import com.google.android.material.tabs.TabLayoutMediator

class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding?=null
    private lateinit var menuPager:  ViewPager2
    private lateinit var menuPagerAdapter: MenuPagerAdapter
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val view = binding.root
        val btnsalir = binding.VolverLogin
        btnsalir.setOnClickListener(){
            findNavController().navigate(R.id.action_menuFragment_to_loginFragment)
        }
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        menuPager = binding.menuPager
        menuPagerAdapter=MenuPagerAdapter(this)
        menuPager.adapter=menuPagerAdapter
        val tablayout = binding.tablayout
        TabLayoutMediator(tablayout, menuPager) { tab, position ->
            if (position==0){
                tab.text = getString(R.string.Builds)
            }
            else if (position==1){
                tab.text = getString(R.string.Favoritos)
            }
            else if (position==2){
                tab.text = getString(R.string.UsuarioMenu)
            }
        }.attach()
    }
}