package com.example.trufllatask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trufllatask.`interface`.ResultInterface
import com.example.trufllatask.model.ReposItem
import com.example.trufllatask.repository.ReposRepository

class ReposViewModel(val reposRepository: ReposRepository) : ViewModel()  , ResultInterface{

    private val _pageNumber = MutableLiveData<Int>()
    val pageNumber: LiveData<Int>
        get() = _pageNumber

    private val _repos = MediatorLiveData<List<ReposItem>>()
    val repos: LiveData<List<ReposItem>>
        get() = _repos

    init {
        _pageNumber.value = 1
    }

    //for first page
    fun getListFirstPage() {
        pageNumber.value?.let { reposRepository.prepareReposList(it, 15) }
    }

    //for next page
    fun  getListNextPage(){
        pageNumber.value?.let { reposRepository.prepareReposList(it.plus(it+1), 15) }

    }

    override fun onSuccess(songModels: List<ReposItem?>?) {
        TODO("Not yet implemented")
    }

    override fun onFailed(errorMsg: String?) {
        TODO("Not yet implemented")
    }
}