package com.lomovskiy.lib.network

import retrofit2.Response
import java.net.URLDecoder

@Suppress("NOTHING_TO_INLINE")
inline fun <T> Response<T>.unwrap(): T? {
    if (isSuccessful) {
        return body()
    } else {
        throw ServerResponseException(
            code = code(),
            msg = (raw().header("ErrorDetails") ?: errorBody()?.string())?.let { rawMsg: String ->
                URLDecoder.decode(rawMsg, Charsets.UTF_8.displayName())
            }
        )
    }
}
