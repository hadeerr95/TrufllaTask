package com.example.trufllatask.constants

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import java.net.InetAddress


class CheckConnectivity{

    companion object{
         fun isNetworkConnected(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
           return when (connectivityManager!!.activeNetworkInfo != null && connectivityManager.activeNetworkInfo!!.isConnected){
               true -> isInternetAvailable()
               false -> false
            }

        }

        private fun isInternetAvailable(): Boolean {

            return try {
                val address: InetAddress = InetAddress.getByName("google.com")
                !address.equals("")
            } catch (e: Exception) {
                false
            }
        }
    }

}