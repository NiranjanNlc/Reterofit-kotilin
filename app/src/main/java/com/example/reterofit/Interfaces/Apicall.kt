package com.example.reterofit.Interfaces

import com.example.reterofit.model.News
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface Apicall
{

    @GET("v2/everything")
    suspend fun getNews(@Query("q") q: String="bitcoin",
                        @Query("from") from: String="2021-01-22",
                        @Query("sortBy") sortBy: String="publishedAt",
                        @Query("apiKey") apiKey: String="a278a7881d7c4b1cbfdfd9967ce22727"): Response<News>

    companion object {
        operator fun invoke(): Apicall {
               val BaseUrl = "https://newsapi.org/"
             val okHttp =OkHttpClient.Builder()
             val builder =  Retrofit.Builder().baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttp.build())
            return builder.build().create(Apicall::class.java)
        }
    }

}