package com.example.core.responseHandler

import com.example.core.resource.Resource

interface ResponseHandler {
    fun <T : Any> handleSuccess(data: T): Resource<T>

    fun <T : Any> handleException(e: Exception): Resource<T>
}