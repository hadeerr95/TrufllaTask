package com.example.trufllatask.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trufllatask.ReposAdapter
import com.example.trufllatask.data.remote.ApiClient
import com.example.trufllatask.data.remote.ApiService
import com.example.trufllatask.databinding.ActivityReposBinding
import com.example.trufllatask.listeners.PaginationScrollListener
import com.example.trufllatask.repository.ReposRepository
import com.example.trufllatask.viewmodel.ReposViewModel

class ReposActivity : AppCompatActivity() {

    private  lateinit var  activityReposBinding: ActivityReposBinding
    private  lateinit var  reposViewModel : ReposViewModel
    private  lateinit var  reposRepository: ReposRepository
    private  lateinit var  apiService: ApiService
    private  lateinit var  reposAdapter: ReposAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityReposBinding = ActivityReposBinding.inflate(layoutInflater)
        setContentView(activityReposBinding.root)
        init()

    }

    private fun init() {
        apiService = ApiClient.getClient()
        reposRepository = ReposRepository(this )
        reposViewModel = ReposViewModel(reposRepository)
        reposViewModel.getListFirstPage()
        val layoutManager : LinearLayoutManager = LinearLayoutManager(this@ReposActivity)

        reposViewModel.repos.observe(this , Observer {
            if(it != null && it.isNotEmpty()){
               reposAdapter = ReposAdapter(it)
                activityReposBinding.reposList.layoutManager = layoutManager
                activityReposBinding.reposList.adapter = reposAdapter
            }
        })

        activityReposBinding.reposList.addOnScrollListener(object : PaginationScrollListener(layoutManager) {
            override fun loadMoreItems() {
                activityReposBinding.loading.visibility = View.VISIBLE
                reposViewModel.getListNextPage()
            }

        })

    }
}