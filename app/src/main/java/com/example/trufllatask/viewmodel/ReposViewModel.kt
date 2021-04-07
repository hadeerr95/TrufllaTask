package com.example.trufllatask.viewmodel

import androidx.lifecycle.*
import com.example.trufllatask.model.ReposItem
import com.example.trufllatask.repository.ReposRepository

class ReposViewModel(private val reposRepository: ReposRepository) : ViewModel() {

    private val _pageNumber = MutableLiveData<Int>()
    private val pageNumber: LiveData<Int>
        get() = _pageNumber

    private var _repos = MediatorLiveData<List<ReposItem>>()
    val repos: LiveData<List<ReposItem>>
        get() = _repos

    init {
        _pageNumber.value = 1
    }

    //for first page
    fun getListFirstPage() {
        pageNumber.value?.let {
            _repos.value =    reposRepository.prepareReposList(it, 15).value
        }
    }

    //for next page
    fun  getListNextPage(){
        pageNumber.value?.let {   _repos.value = reposRepository.prepareReposList(it.plus(it+1), 15).value }

    }
}