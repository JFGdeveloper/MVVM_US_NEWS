package com.javidev.mvvm_compose.data.repository

import com.javidev.mvvm_compose.data.model.News
import com.javidev.mvvm_compose.data.provider.NewsProvider
import javax.inject.Inject

interface NewRepository{
    suspend fun getNews(country: String): List<News>
    fun getNew(title: String): News
}


class NewRepositoryImp
@Inject
constructor(private val newsProvider: NewsProvider): NewRepository{

    private var news: List<News> = emptyList()

    override suspend fun getNews(country: String): List<News> {
        val apiResponse = newsProvider.topHeadLines(country).body()
        // valido la respuesta de la api
        if (apiResponse?.status == "error"){
            when(apiResponse.status){
                "apiKeyMissing" -> throw MissingApiKeyException()
                "apiKeyInvalid" -> throw ApiKeyInvalidException()
                else -> throw Exception()
            }
        }

        news = apiResponse?.articles ?: emptyList()
        return news
    }

    override fun getNew(title: String): News {
        return news.first { it.title == title }
    }


}

// creado para las excepciones
class MissingApiKeyException: java.lang.Exception()
class ApiKeyInvalidException: java.lang.Exception()