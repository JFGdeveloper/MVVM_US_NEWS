package com.javidev.mvvm_compose.presentation.screens.detailScreen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.javidev.mvvm_compose.data.model.News
import com.javidev.mvvm_compose.data.repository.NewRepository
import com.javidev.mvvm_compose.presentation.screens.listScreen.ListScreenViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel
@Inject constructor(
    private val repository: NewRepository,
): ViewModel() {

     private var mutableNews = MutableLiveData<News>()
     var new: LiveData<News> = mutableNews


    fun getTitle(title:String): LiveData<News>{
        viewModelScope.launch(Dispatchers.IO){
            val new = repository.getNew(title)
            mutableNews.postValue(new)
        }
        return new
    }








// todo revisa si lo que coges aqui es el ultimo y concuerda con el del title

}