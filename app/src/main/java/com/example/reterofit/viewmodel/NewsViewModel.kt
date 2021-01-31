package com.example.reterofit.viewmodel

import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reterofit.model.Article
import com.example.reterofit.model.News
import com.example.reterofit.repository.Repo
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class NewsViewModel(private  val repo: Repo): ViewModel(), Observable
{
    private lateinit var job: Job;
   private  val _news = MutableLiveData<List<Article>>()
    val news : LiveData<List<Article>>
        get()=_news

    fun getNews()
    {
        Courtines.ioThenMain({repo.getNews()},{
            if (it != null) {
                _news.value = it.articles
            }
        })

    }


    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}