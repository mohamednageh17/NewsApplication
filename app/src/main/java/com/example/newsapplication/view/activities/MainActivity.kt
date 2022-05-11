package com.example.newsapplication.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapplication.adapters.ViewPagerAdapter
import com.example.newsapplication.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        setupViewPager()

    }

    private fun setupTabs(){
        binding.tabs.addTab(binding.tabs.newTab().setText("Local"))
        binding.tabs.addTab(binding.tabs.newTab().setText("General"))
        binding.tabs.addTab(binding.tabs.newTab().setText("Saved"))

        binding.tabs.tabGravity = TabLayout.GRAVITY_FILL
    }

    private fun setupViewPager() {
        setupTabs()

        val adapter = ViewPagerAdapter( supportFragmentManager, binding.tabs.tabCount)
        binding.viewPager.adapter = adapter
        binding.viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabs))

        binding.tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.viewPager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

    }
}