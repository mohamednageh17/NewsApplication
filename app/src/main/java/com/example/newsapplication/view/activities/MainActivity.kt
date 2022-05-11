package com.example.newsapplication.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.newsapplication.adapters.ViewPagerAdapter
import com.example.newsapplication.databinding.ActivityMainBinding
import com.example.newsapplication.view.fragments.FavouriteArticlesFragment
import com.example.newsapplication.view.fragments.GeneralArticlesFragment
import com.example.newsapplication.view.fragments.LocalArticlesFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        setupViewPager(binding.viewPager)

        binding.tabs.setupWithViewPager(binding.viewPager)
    }

    private fun setupViewPager(viewpager: ViewPager) {
        var adapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        // LoginFragment is the name of Fragment and the Login
        // is a title of tab
        adapter.addFragment(LocalArticlesFragment(), "Local articles")
        adapter.addFragment(GeneralArticlesFragment(), "General articles")
        adapter.addFragment(FavouriteArticlesFragment(), "Saved articles")

        // setting adapter to view pager.
        viewpager.adapter = adapter
    }
}