package com.javidev.mvvm_compose.di

import com.javidev.mvvm_compose.data.provider.NewsProvider
import com.javidev.mvvm_compose.data.repository.NewRepository
import com.javidev.mvvm_compose.data.repository.NewRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsRepository(provider: NewsProvider): NewRepository = NewRepositoryImp(provider)


}