package com.javidev.mvvm_compose.presentation.screens.detailScreen

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javidev.mvvm_compose.data.model.News
import com.javidev.mvvm_compose.data.repository.NewRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel
@Inject constructor(
    private val repository: NewRepository
): ViewModel() {

    // nueva manera en compose
    var  news = mutableStateListOf<News>()
        private set

    fun getNewByTitle(title: String): News {
        viewModelScope.launch (Dispatchers.IO){
            val new: News = repository.getNew( title)
            news.add(new)
        }
        return news[news.size]
    }



}