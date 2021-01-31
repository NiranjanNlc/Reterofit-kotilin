package com.example.reterofit

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reterofit.Interfaces.Apicall
import com.example.reterofit.Interfaces.ServiceBuilder
import com.example.reterofit.adapter.NewsAdapter
import com.example.reterofit.repository.ApiRequest
import com.example.reterofit.repository.Repo
import com.example.reterofit.viewmodel.ModelViewFactory
import com.example.reterofit.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.news_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext


class News : Fragment() {

//    companion object {
//        fun newInstance() = News()
//    }

    private lateinit var viewModel: NewsViewModel
    private lateinit var factory:ModelViewFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val apicall= Apicall()
        val repo = Repo(apicall)
        factory = ModelViewFactory(repo)
        viewModel = ViewModelProviders.of(this, factory).get(NewsViewModel::class.java)
        viewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        viewModel.getNews()
        viewModel.news.observe(viewLifecycleOwner, Observer {articles->
            recycler1.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter= NewsAdapter(articles.toTypedArray())
            }
        })
    }

}
