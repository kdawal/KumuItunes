package com.example.itunes.data.util

import com.example.itunes.data.model.BaseResponse
import retrofit2.Response

/**
 * Handles api request for better error handling
 */
inline fun <reified T> evaluateCall(
    call: () -> Response<BaseResponse<T>>
): Resource<T> {
    try {
        val response = call()
        val data = response.body()?.results
        val errorBody = response.errorBody()
        if (response.isSuccessful) {
            return Resource.Success(data)
        } else {
            if (response.code() in 500..600) {
                return Resource.Error(response.message() ?: "Server Error")
            }
            return if (errorBody != null) {
                Resource.Error(errorBody.toString())
            } else {
                Resource.Error(response.message())
            }
        }
    } catch (e: Exception) {
        return Resource.Error(e.message ?: e.toString())
    }
}