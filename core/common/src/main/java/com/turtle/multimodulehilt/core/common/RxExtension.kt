package com.turtle.multimodulehilt.core.common

import io.reactivex.rxjava3.core.Single
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

fun <T> Single<Response<T>>.handleNetworkException(): Single<Response<T>> =
    flatMap { response ->
        if (!response.isSuccessful || response.body() == null) {
            throw Exception("response fail")
        } else {
            when (response.code()) {
                200 -> return@flatMap Single.just(response)
                else -> throw Exception("response fail { code: ${response.code()}")
            }
        }
    }
    .onErrorResumeNext { exception ->
        when (exception) {
            is SocketTimeoutException -> return@onErrorResumeNext Single.error(Exception("Server Not Found"))
            is UnknownHostException -> return@onErrorResumeNext Single.error(Exception("check internet is connected"))
            is IOException -> return@onErrorResumeNext Single.error(Exception("Unknown Network error"))
            is HttpException -> {
                return@onErrorResumeNext Single.error(Exception("Http Exception"))
            }
            else -> return@onErrorResumeNext Single.error(exception)
        }
    }

