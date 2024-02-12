package com.example.buildblitz.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class viewpagerAdapter(fragment: Fragment):FragmentStateAdapter(fragment)  {
    override fun getItemCount(): Int = 2
companion object{
    private const val ARG_OBJECT = "object"
}
    override fun createFragment(position: Int): Fragment {
        val fragment = UnoFragment()
        val fragment2= DosFragment()
        if (position==0){
            return  fragment
        }
        else {
            return fragment2
        }
    }
}