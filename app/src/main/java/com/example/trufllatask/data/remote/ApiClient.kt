package com.example.trufllatask.data.remote

import android.util.Log
import com.example.trufllatask.BuildConfig.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private lateinit var apiService: ApiService

    fun getClient(): ApiService {
        val myBuilder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        val retrofit: Retrofit = myBuilder.client(httpClient.build()).build()
        apiService = retrofit.create(
            ApiService::class.java)
        return apiService
    }


}