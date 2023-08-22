package com.example.demokotlin.student

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class StudentManagementViewModel : ViewModel() {

    private val _data = MutableLiveData<List<Student>>(listOf())
    val data: LiveData<List<Student>> get() = _data

    fun addStudent(name: String, msv: String, classroom: String) {
        val temp = data.value
        temp?.toMutableList()?.add(Student(
            name = name,
            msv = msv,
            classroom = classroom
        ))
        _data.value = temp?.toList()

        Log.d("StudentVM", _data.value.toString() + "\n" + temp.toString())
    }

    fun updateStudent(name: String, classroom: String, msv: String) {
        data.value?.let { list ->
            val index = list.indexOf(list.find { it.msv == msv })
            _data.value?.toMutableList()?.set(
                index, list[index].copy(
                    name = name,
                    classroom = classroom
                )
            )
        }
    }
}