package com.luisguzman.myapplication1.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luisguzman.myapplication1.domain.model.Entries
import com.luisguzman.myapplication1.domain.repositories.HomeRepository
import com.luisguzman.myapplication1.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeState.Success(emptyList()))
    val uiState = _uiState.asStateFlow()

    private var _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

//    private var _listEntries = MutableStateFlow<List<Entries>>(listOf())
//    val listEntries = _listEntries.asStateFlow()

    fun getEntries() {
        viewModelScope.launch(Dispatchers.IO) {
           repository.getEntries().let {
               when(it) {
                   Response.Loading -> _loading.value = true
                   is Response.Success -> {
                       _loading.value = false
                       _uiState.value = HomeState.Success(it.data)
                   }
                   is Response.Error -> {
                       _loading.value = false
                   }
               }
           }
        }
    }
}

sealed class HomeState {
    data class Success(val data: List<Entries>): HomeState()
    data class Error(val exception: Throwable): HomeState()
}