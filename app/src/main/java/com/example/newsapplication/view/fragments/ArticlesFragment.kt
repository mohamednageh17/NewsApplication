package com.example.newsapplication.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.domain.models.NewsArticle
import com.example.newsapplication.adapters.ArticlesAdapter
import com.example.newsapplication.databinding.ArticlesFragmentBinding
import com.example.newsapplication.handle_state.StateData
import com.example.newsapplication.viewmodel.ArticlesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArticlesFragment:Fragment() {
    lateinit var binding: ArticlesFragmentBinding
    private val adapter by lazy{ ArticlesAdapter() }
    private val articlesViewModel: ArticlesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= ArticlesFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        articlesObserver()
    }

    private fun setupRecyclerView(){
        binding.articlesRecyclerView.adapter=adapter
    }

    private fun articlesObserver(){
        articlesViewModel.articleLiveDate.observe(viewLifecycleOwner){
            it?.let {
                when(it.status){
                    StateData.DataStatus.LOADING->showProgress()
                    StateData.DataStatus.SUCCESS->handleSuccessStatus(it)
                    StateData.DataStatus.ERROR->handleErrorStatus(it.error)
                }
            }
        }
    }

    private fun showProgress() {
        binding?.progressBar?.isVisible = true
    }

    private fun hideProgress() {
        binding?.progressBar?.isVisible = false
    }

    private fun handleSuccessStatus(it: StateData<List<NewsArticle>>) {
        hideProgress()
        adapter.submitList(it.data)
    }

    private fun handleErrorStatus(it:Throwable?) {
        hideProgress()
        Toast.makeText(requireContext(),it!!.message, Toast.LENGTH_LONG).show()
    }
}