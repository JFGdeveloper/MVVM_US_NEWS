package com.javidev.mvvm_compose.data.repository

import com.javidev.mvvm_compose.data.model.News

interface NewRepository{
    suspend fun getNews(country: String): List<News>
    fun getNew(title: String): News
}


class NewRepositoryImp: NewRepository{
    override suspend fun getNews(country: String): List<News> {
        TODO("Not yet implemented")
    }

    override fun getNew(title: String): News {
        TODO("Not yet implemented")
    }


}