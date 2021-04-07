package com.example.trufllatask.repository

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import retrofit2.Callback
import androidx.lifecycle.ViewModel
import com.example.trufllatask.ReposApp
import com.example.trufllatask.constants.CheckConnectivity
import com.example.trufllatask.data.remote.ApiClient
import com.example.trufllatask.data.remote.ApiService
import com.example.trufllatask.model.MyResponse
import com.example.trufllatask.model.ReposItem
import retrofit2.Call
import retrofit2.Response
import timber.log.Timber

class ReposRepository  (context: Context): ViewModel() {


    private var  myContext : Context = context
    private var apiService :ApiService = ApiClient.getClient()

    fun  prepareReposList(page : Int , apiReturnNumber : Int): LiveData<List<ReposItem>> {
        return if(checkConnectivity() || getReposListFromLocale().value?.size!! > 0){
            Timber.e("prepareReposList")
            //get repos list from api
            getReposListFromApi(page , apiReturnNumber)


        }else {
            //get repos list from locale
            getReposListFromLocale()

        }
    }

    private fun getReposListFromLocale(): LiveData<List<ReposItem>> {
        return ReposApp.db!!.reposItemDao().getImageItemList()

    }

    private fun getReposListFromApi(page : Int , apiReturnNumber : Int): LiveData<List<ReposItem>> {
        Timber.e("getReposListFromApi")
        apiService.getReposList(page , apiReturnNumber).enqueue(object : Callback<MyResponse>{
            override fun onResponse(call: Call<MyResponse>, response: Response<MyResponse>)
            {
                Timber.e("onResponse $response")
                if(response.isSuccessful){
                    ReposApp.db!!.reposItemDao().deleteAllImageItems()
                    ReposApp.db!!.reposItemDao().insertImageItems(response.body()?.repos!!)
                }
            }
            override fun onFailure(call: Call<MyResponse>, t: Throwable) {
                Toast.makeText(myContext , t.message , Toast.LENGTH_LONG).show()
            }

        })
        return ReposApp.db!!.reposItemDao().getImageItemList()

    }


    private fun checkConnectivity(): Boolean = CheckConnectivity.isNetworkConnected(myContext)



}