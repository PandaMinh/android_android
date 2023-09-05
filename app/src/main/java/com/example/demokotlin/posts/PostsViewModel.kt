package com.example.demokotlin.posts

import android.icu.text.CaseMap.Title
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PostsViewModel : ViewModel() {

    private val _data = MutableLiveData<List<Posts>>(listOf())
    val data: LiveData<List<Posts>> get() = _data

    fun addPosts(title: String, body: String){
        val temp = data.value
        temp?.toMutableList()?.add(Posts(
            title = title,
            body = body
        ))
        _data.value = temp?.toList()
    }

    fun updatePosts(title: String, body: String){
        data.value?.let { list ->
            val index = list.indexOf(list.find { it.title == title })
            _data.value?.toMutableList()?.set(
                index, list[index].copy(
                    body = body
                )
            )
        }
    }
}