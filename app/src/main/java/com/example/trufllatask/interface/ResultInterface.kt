package com.example.trufllatask.`interface`

import com.example.trufllatask.model.ReposItem

interface ResultInterface {
    fun onSuccess(songModels: List<ReposItem?>?)

    fun onFailed(errorMsg: String?)
}