package com.javidev.mvvm_compose.presentation.screens.listScreen

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
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

    //private val _news = MutableLiveData<List<News>>()

    // nueva manera en compose
    var  news = mutableStateListOf<List<News>>(emptyList())
     private set

     @JvmName("getNews1")
     fun getNews(): SnapshotStateList<List<News>> {
        viewModelScope.launch (Dispatchers.IO){
            /*
            val news = repository.getNews("US")
            _news.postValue(news)
             */
            val new: List<News> = repository.getNews("US")
            news.add(new)
        }
        return news
    }

}