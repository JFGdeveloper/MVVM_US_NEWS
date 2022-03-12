package com.javidev.mvvm_compose.data.provider

import com.javidev.mvvm_compose.data.model.NewsApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val APY_KEY = "7c70bd01254141808e75d0a7d0e12e04"

interface NewsProvider{
    @GET("top-headlines?apiKey=$APY_KEY")
    suspend fun topHeadLines(@Query("country") country: String): Response<NewsApiResponse>
}