package com.example.newsapplication.view.activities

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.domain.models.NewsArticle
import com.example.newsapplication.R
import com.example.newsapplication.databinding.ActivityArticleDetailsBinding

class ArticleDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArticleDetailsBinding
    private lateinit var newsArticle: NewsArticle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar()

        newsArticle = (intent.getParcelableExtra("article") as? NewsArticle)!!

        initView(newsArticle)
    }

    private fun supportActionBar() {
        val actionbar = supportActionBar
        actionbar!!.title = "Article Details"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun initView(newsArticle: NewsArticle) {
        Glide.with(binding.articleImageView)
            .load(newsArticle.urlToImage)
            .placeholder(R.drawable.no_image)
            .into(binding.articleImageView)
        binding.articleTitleTextView.text = newsArticle.title
        binding.articlePublishedAtTextView.text = newsArticle.publishedAt!!.substring(0, 10)
        binding.articleSourceTextView.text = "${newsArticle.articleSource!!.name}"
        binding.articleDescriptionTextView.text = newsArticle.description
        setupLink(binding.articleUrlTextView, newsArticle.url)
    }

    private fun setupLink(textView: TextView, url: String?) {
        textView.text = url
        textView.movementMethod = LinkMovementMethod.getInstance()
        textView.setLinkTextColor(Color.BLUE)
        textView.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(browserIntent)
        }
    }
}