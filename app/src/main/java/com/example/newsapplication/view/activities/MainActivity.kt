package com.example.newsapplication.view.activities

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.domain.models.NewsArticle
import com.example.newsapplication.R
import com.example.newsapplication.adapters.ArticlesAdapter
import com.example.newsapplication.databinding.ActivityMainBinding
import com.example.newsapplication.handle_state.StateData
import com.example.newsapplication.handle_state.StateLiveData
import com.example.newsapplication.viewmodel.ArticlesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter by lazy{ ArticlesAdapter()}
    private val articlesViewModel:ArticlesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        articlesObserver()
    }

    private fun setupRecyclerView(){
        binding.articlesRecyclerView.adapter=adapter
    }

    private fun articlesObserver(){
        articlesViewModel.articleLiveDate.observe(this, Observer {
            it?.let {
               when(it.status){
                   StateData.DataStatus.LOADING->showProgress()
                   StateData.DataStatus.SUCCESS->handleSuccessStatus(it)
                   StateData.DataStatus.ERROR->handleErrorStatus(it.error)
               }
            }
        })
    }

    private fun showProgress() {
        binding?.progressBar?.isVisible = true
    }

    private fun hideProgress() {
        binding?.progressBar?.isVisible = false
    }

    private fun handleSuccessStatus(it:StateData<List<NewsArticle>>) {
        hideProgress()
        adapter.submitList(it.data)
    }

    private fun handleErrorStatus(it:Throwable?) {
        hideProgress()
        Toast.makeText(this,it!!.message,Toast.LENGTH_LONG).show()
        Log.d(TAG, "nageh handleErrorStatus: ${it.message}")
    }

}