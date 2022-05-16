package com.example.tytytest.data.repository

import android.util.Log
import retrofit2.Response
import java.io.IOException

abstract class SafeApiRequest {

    //Отслежка ошибок которые приходят из Api
    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw  ApiException(response.code().toString())
        }
    }
}

class ApiException(message: String) : IOException(message)