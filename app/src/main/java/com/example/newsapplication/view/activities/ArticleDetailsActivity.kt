package com.example.newsapplication.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsapplication.R

class ArticleDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_details)

        supportActionBar()
    }

    private fun supportActionBar(){
        val actionbar = supportActionBar
        actionbar!!.title = "Article Details"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}