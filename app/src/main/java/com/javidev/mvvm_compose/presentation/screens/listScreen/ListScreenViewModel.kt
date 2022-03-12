package com.javidev.mvvm_compose.presentation.screens.listScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javidev.mvvm_compose.data.model.News
import com.javidev.mvvm_compose.data.repository.NewRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor(
    private val repository: NewRepository
): ViewModel() {

    private val _news = MutableLiveData<List<News>>()

    suspend fun getNews(country: String): LiveData<List<News>>{
        viewModelScope.launch (Dispatchers.IO){
            val news = repository.getNews("US")
            _news.postValue(news)
        }
        return _news
    }

}