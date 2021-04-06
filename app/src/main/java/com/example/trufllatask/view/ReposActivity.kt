package com.example.trufllatask.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.trufllatask.ReposAdapter
import com.example.trufllatask.databinding.ActivityReposBinding
import com.example.trufllatask.viewmodel.ReposViewModel

class ReposActivity : AppCompatActivity() {

    private  lateinit var  activityReposBinding: ActivityReposBinding
    private  val  reposViewModel : ReposViewModel  by viewModels()
    private  lateinit var  reposAdapter: ReposAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityReposBinding = ActivityReposBinding.inflate(layoutInflater)
        setContentView(activityReposBinding.root)
        initViewModel()

    }

    private fun initViewModel() {
        reposViewModel.getListFirstPage()
        reposViewModel.repos.observe(this , Observer {
            if(it != null && it.isNotEmpty()){

            }
        })

    }
}