package com.example.reterofit.Interfaces

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceBuilder
{

    private const val BaseUrl = "http://api.openweathermap.org/"
    private val okHttp =OkHttpClient.Builder()
    private val builder =  Retrofit.Builder().baseUrl(BaseUrl)
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(okHttp.build())
    private val retrofit = builder.build().create(Apicall::class.java)


}