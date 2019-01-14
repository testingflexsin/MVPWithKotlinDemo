package com.cudos.mvpwithkotlindemo.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log

class NetworkStatus {

    private var connected = false

    fun isOnline(con: Context): Boolean {
        try {
            val connectivityManager = con
                    .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val networkInfo = connectivityManager.activeNetworkInfo
            connected = (networkInfo != null && networkInfo.isAvailable
                    && networkInfo.isConnected)
            return connected

        } catch (e: Exception) {
            println("CheckConnectivity Exception: " + e.message)
            Log.v("connectivity", e.toString())
        }

        return connected
    }

}