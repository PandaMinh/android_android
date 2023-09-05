package com.example.demokotlin.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.demokotlin.data.LoginRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel: ViewModel() {
    private val _data = MutableLiveData<List<Posts>>(listOf())
    val data: LiveData<List<Posts>> get() = _data

    fun login(userId: String, Id: String){
        viewModelScope.launch {
            _data.value = API.authService.getListPosts()
        }
    }
}