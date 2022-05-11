package com.example.newsapplication.adapters


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.newsapplication.view.fragments.FavouriteArticlesFragment
import com.example.newsapplication.view.fragments.GeneralArticlesFragment
import com.example.newsapplication.view.fragments.LocalArticlesFragment

class ViewPagerAdapter(fm: FragmentManager,
                       var totalTabs: Int,): FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                LocalArticlesFragment()
            }
            1 -> {
                GeneralArticlesFragment()
            }
            2 -> {
                FavouriteArticlesFragment()
            }
            else -> getItem(position)
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Local"
            1 -> "General"
            2 -> "Saved"
            else -> ""
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }

}