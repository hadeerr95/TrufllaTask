package com.example.trufllatask.constants

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class CheckConnectivity(val con){





    companion object{
        private  var context: Context? = null

        public fun isNetworkAvailable(): Boolean {
            val connectivityManager = this.context?.getSystemService(Context.CONNECTIVITY_SERVICE)
            return if (connectivityManager is ConnectivityManager) {
                val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
                networkInfo?.isConnected ?: false
            } else false
        }
    }

}