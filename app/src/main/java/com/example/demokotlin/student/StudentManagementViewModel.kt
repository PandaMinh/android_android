package com.example.demokotlin.student

import androidx.lifecycle.ViewModel

class StudentManagementViewModel: ViewModel() {

    private val _data = mutableListOf<Student>()
    val data: List<Student> get() = _data.toList()

    fun addStudent(name: String, msv: String, classroom: String){
        _data.add(
            Student(
                name = name,
                msv = msv,
                classroom = classroom
            )
        )
    }

    fun updateStudent(name: String, classroom: String, msv: String){
        val index = data.indexOf(data.find { it.msv == msv})
        _data[index] = data[index].copy(
            name = name,
            classroom = classroom
        )
    }
}