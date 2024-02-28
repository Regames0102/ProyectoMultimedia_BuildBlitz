package com.example.buildblitz.pagerMenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.buildblitz.fragmentos.BuildsListFragment
import com.example.buildblitz.fragmentos.DetailBuildsFragment
import com.example.buildblitz.fragmentos.DetailFavBuildsFragment
import com.example.buildblitz.fragmentos.FavBuildsListFragment
import com.example.buildblitz.fragmentos.UserInfoFragment

class MenuPagerAdapter(fragment: Fragment):FragmentStateAdapter(fragment)  {
    override fun getItemCount(): Int = 3
companion object{
    private const val ARG_OBJECT = "object"
}
    override fun createFragment(position: Int): Fragment {
        val fragment = BuildsListFragment()
        val fragment2= FavBuildsListFragment()
        val fragment3= UserInfoFragment()
        if (position==0){
            return fragment
        }
        else if (position==1){
            return fragment2
        }
        else {
            return fragment3
        }
    }
}