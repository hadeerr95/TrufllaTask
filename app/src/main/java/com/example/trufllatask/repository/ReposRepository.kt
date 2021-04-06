package com.example.trufllatask.repository

import android.content.Context
import retrofit2.Callback
import androidx.lifecycle.ViewModel
import com.example.trufllatask.`interface`.ResultInterface
import com.example.trufllatask.constants.CheckConnectivity
import com.example.trufllatask.data.remote.ApiService
import com.example.trufllatask.model.MyResponse
import retrofit2.Call
import retrofit2.Response

class ReposRepository  (context: Context , apiService: ApiService , resultInterface: ResultInterface): ViewModel() {


    private var  myContext : Context = context
    private var apiService :ApiService = apiService
    private var resultInterface = resultInterface

    fun  prepareReposList(page : Int , apiReturnNumber : Int){
        if(checkConnectivity()){
            //get repos list from api
            getReposListFromApi(page , apiReturnNumber)


        }else {
            //get repos list from locale
            getReposListFromLocale()

        }
    }

    private fun getReposListFromLocale() {

    }

    private fun getReposListFromApi(page : Int , apiReturnNumber : Int) {

        apiService.getReposList(page , apiReturnNumber).enqueue(object : Callback<MyResponse>{
            override fun onResponse(call: Call<MyResponse>, response: Response<MyResponse>) {
                if(response.isSuccessful)
                    resultInterface.onSuccess(response.body()?.repos)
                else
                    resultInterface.onFailed(response.message())
            }

            override fun onFailure(call: Call<MyResponse>, t: Throwable) {
                 resultInterface.onFailed(t.message)
            }

        })

    }


    private fun checkConnectivity(): Boolean = CheckConnectivity.isNetworkConnected(myContext)



}