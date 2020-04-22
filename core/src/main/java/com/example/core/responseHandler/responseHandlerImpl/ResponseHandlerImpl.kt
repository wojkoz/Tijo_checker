package com.example.core.responseHandler.responseHandlerImpl

import com.example.core.resource.Resource
import com.example.core.responseHandler.ResponseHandler
import retrofit2.HttpException

class ResponseHandlerImpl : ResponseHandler {
    override fun <T : Any> handleSuccess(data: T): Resource<T> {
        return Resource.success(data)
    }

    override fun <T : Any> handleException(e: Exception): Resource<T> {
        return when(e) {
            is HttpException -> Resource.error(msg = getErrorMessage(e.code()), data = null)
            else -> Resource.error(msg = "Check your internet connection!", data = null)
        }
    }

    private fun getErrorMessage(code: Int): String {
        return when (code) {
            404 -> "Not found"
            else -> "Something went wrong"
        }
    }

}