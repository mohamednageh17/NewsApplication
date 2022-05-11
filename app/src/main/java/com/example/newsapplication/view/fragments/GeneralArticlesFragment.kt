package com.example.newsapplication.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsapplication.databinding.GeneralArticlesFragmentBinding


class GeneralArticlesFragment:BaseFragment() {
    private lateinit var binding:GeneralArticlesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= GeneralArticlesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setProgress(binding.progressBar)
        articlesViewModel.getNewsByCategory(category = "business")

        setupRecyclerView()
        articlesObserver()
    }

    private fun setupRecyclerView(){
        binding.recyclerView.adapter=adapter
    }
}