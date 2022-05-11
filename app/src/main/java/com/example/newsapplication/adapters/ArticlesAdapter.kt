package com.example.newsapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.NewsArticle
import com.example.newsapplication.R
import com.example.newsapplication.databinding.ArticleItemBinding
import java.time.ZonedDateTime

class ArticlesAdapter: ListAdapter<NewsArticle, ArticlesAdapter.ArticlesViewHolder>(ArticlesDiffCallBacks()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        return ArticlesViewHolder(
            ArticleItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ArticlesViewHolder(private val binding: ArticleItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(data:NewsArticle){
            binding.root.animation= AnimationUtils.loadAnimation(binding.root.context, R.anim.animation)
            Glide.with(binding.articleImageView)
                .load(data.urlToImage)
                .placeholder(R.drawable.no_image)
                .into(binding.articleImageView)
            binding.articleTitleTextView.text=data.title
            binding.articleSourceTextView.text=data.articleSource!!.name
            binding.dateTextView.text= ZonedDateTime.parse(data.publishedAt).toString().substring(0,10)
        }
    }

    class ArticlesDiffCallBacks: DiffUtil.ItemCallback<NewsArticle>() {
        override fun areItemsTheSame(oldItem: NewsArticle, newItem: NewsArticle): Boolean {
            return oldItem.title==newItem.title
                    && oldItem.articleSource==newItem.articleSource
                    && oldItem.author==newItem.author
                    && oldItem.content==newItem.content
                    && oldItem.description==newItem.description
                    && oldItem.publishedAt==newItem.publishedAt
                    && oldItem.url== newItem.url
                    && oldItem.urlToImage==newItem.urlToImage
        }

        override fun areContentsTheSame(oldItem: NewsArticle, newItem: NewsArticle): Boolean {
            return oldItem==newItem
        }
    }
}