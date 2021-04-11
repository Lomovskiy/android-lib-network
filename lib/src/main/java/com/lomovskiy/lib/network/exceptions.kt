package com.lomovskiy.lib.network

class NoNetworkException : RuntimeException()

class ServerResponseException(
    val code: Int, val msg: String? = null
) : RuntimeException()
