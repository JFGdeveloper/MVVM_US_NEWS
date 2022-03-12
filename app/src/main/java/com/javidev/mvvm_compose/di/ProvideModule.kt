package com.javidev.mvvm_compose.di

import com.javidev.mvvm_compose.data.provider.NewsProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ProvideModule {

    @Provides
    @Named("BaseUrl")
    fun provideBaseUrl() = "https://newsapi.org/v2/".toHttpUrl()

    @Singleton
    @Provides
    fun provideRetrofit(@Named("BaseUrl") baseUrl: HttpUrl): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Provides
    @Singleton
    fun provideNewProvider(retrofit: Retrofit): NewsProvider{
        return retrofit.create(NewsProvider::class.java)
    }
}

//todo ver por el minuto 15 para seguir 