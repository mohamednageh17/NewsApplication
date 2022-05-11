package com.example.newsapplication.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newsapplication.databinding.FavouriteArticlesFragmentBinding

class FavouriteArticlesFragment:Fragment() {
    private lateinit var binding:FavouriteArticlesFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FavouriteArticlesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}