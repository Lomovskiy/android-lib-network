package com.lomovskiy.lib.network

import okhttp3.Interceptor
import okhttp3.Response

class NetworkAvailableInterceptor(
    private val networkChecker: NetworkChecker
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!networkChecker.isConnectedToNetwork()) {
            throw NoNetworkException()
        }
        return chain.proceed(chain.request().newBuilder().build())
    }

}
