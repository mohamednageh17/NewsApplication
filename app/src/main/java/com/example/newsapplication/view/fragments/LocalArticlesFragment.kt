package com.example.newsapplication.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.domain.models.NewsArticle
import com.example.newsapplication.adapters.ArticlesAdapter
import com.example.newsapplication.databinding.LocalArticlesFragmentBinding
import com.example.newsapplication.handle_state.StateData
import com.example.newsapplication.viewmodel.ArticlesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocalArticlesFragment:BaseFragment() {
    lateinit var binding: LocalArticlesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= LocalArticlesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setProgress(binding.progressBar)
        articlesViewModel.getNewsByCountry(countryName = "eg")

        setupRecyclerView()
        articlesObserver()
    }

    private fun setupRecyclerView(){
        binding.articlesRecyclerView.adapter=adapter
    }


}