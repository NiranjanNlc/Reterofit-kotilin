package com.example.reterofit.adapter

import com.example.reterofit.R
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.reterofit.databinding.RecyclerNewsBinding
import com.example.reterofit.model.Article

class NewsAdapter(val newsList: Array<Article>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>()
{
    inner class NewsViewHolder(val recyclerNewsBinding: RecyclerNewsBinding):RecyclerView.ViewHolder(recyclerNewsBinding.root)

    override fun getItemCount() =newsList.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        NewsViewHolder(
         DataBindingUtil.inflate(
             LayoutInflater.from(parent.context),R.layout.recycler_news,parent,false
         )
        )

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int)
    {
     holder.recyclerNewsBinding.news=  newsList[position]
    }
}