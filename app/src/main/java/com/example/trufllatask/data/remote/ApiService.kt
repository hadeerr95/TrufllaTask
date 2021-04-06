package com.example.trufllatask.data.remote

import com.example.trufllatask.constants.Constants
import com.example.trufllatask.model.MyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers("Accept-Language : en")
    @GET(Constants.repos_api_word)
    fun getReposList(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Call<MyResponse>
}
