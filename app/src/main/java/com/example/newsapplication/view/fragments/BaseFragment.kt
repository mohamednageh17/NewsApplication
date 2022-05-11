package com.example.newsapplication.view.fragments

import android.content.Intent
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.domain.models.NewsArticle
import com.example.newsapplication.adapters.ArticlesAdapter
import com.example.newsapplication.handle_state.StateData
import com.example.newsapplication.view.activities.ArticleDetailsActivity
import com.example.newsapplication.viewmodel.ArticlesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

abstract class BaseFragment:Fragment() {

    val articlesViewModel: ArticlesViewModel by viewModel()

    val adapter by lazy{ ArticlesAdapter(ArticlesAdapter.OnItemClickListener {
        launchDetailsActivity(it)
    }) }

    private fun launchDetailsActivity(newsArticle: NewsArticle){
        val intent=Intent(activity,ArticleDetailsActivity::class.java)
        intent.putExtra("article",newsArticle)
        startActivity(intent)
    }
    private var progressBar:ProgressBar?=null

    fun setProgress(progressBar: ProgressBar){
        this.progressBar=progressBar
    }

     fun articlesObserver(){
        articlesViewModel.articleLiveDate.observe(viewLifecycleOwner){
            it?.let {
                when(it.status){
                    StateData.DataStatus.LOADING->showProgress()
                    StateData.DataStatus.SUCCESS->handleSuccessStatus(it)
                    StateData.DataStatus.ERROR->handleErrorStatus(it.error)
                    null -> TODO()
                }
            }
        }
    }

     private fun showProgress() {
        progressBar!!.isVisible = true
    }

     private fun hideProgress() {
       progressBar!!.isVisible = false
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