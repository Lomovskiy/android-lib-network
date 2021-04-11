package com.lomovskiy.lib.network

import android.content.Context
import android.net.ConnectivityManager

interface NetworkChecker {

    fun isConnectedToNetwork(): Boolean

}

class NetworkCheckerImpl(context: Context) : NetworkChecker {

    private val connectivityManager: ConnectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    override fun isConnectedToNetwork(): Boolean {
        return connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo!!.isConnected
    }

}
