package com.example.reterofit.repository

import com.example.reterofit.Interfaces.Apicall

class Repo(private  val apicall: Apicall): ApiRequest()
{
    suspend fun getNews()=  apiRequest { apicall.getNews() }
}