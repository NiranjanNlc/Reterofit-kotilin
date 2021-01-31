package com.example.reterofit.repository

import android.util.Log
import retrofit2.Response
import java.io.IOException

abstract class  ApiRequest {

    suspend fun<T: Any> apiRequest(call: suspend () -> Response<T>) : T{
        val response = call.invoke()
        if(response.isSuccessful){
            return response.body()!!
        }else{
            //@todo handle api exception handling
            println("errot"+response.toString())
            throw ApiException(response.code().toString())
        }
    }

}

class ApiException(message: String): IOException(message)