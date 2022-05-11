package com.example.newsapplication.adapters

import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {

    private final var fragmentList1: ArrayList<Fragment> = ArrayList()
    private final var fragmentTitleList1: ArrayList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return fragmentList1[position]
    }

    override fun getPageTitle(position: Int): CharSequence {
        return fragmentTitleList1[position]
    }

    override fun getCount(): Int {
        return fragmentList1.size
    }

    fun addFragment(fragment: Fragment, title: String) {
        fragmentList1.add(fragment)
        fragmentTitleList1.add(title)
    }
}