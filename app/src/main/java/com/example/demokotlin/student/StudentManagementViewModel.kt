package com.example.demokotlin.student

import androidx.lifecycle.ViewModel

class StudentManagementViewModel: ViewModel() {

    private val _data = mutableListOf<Student>()
    val data: List<Student> get() = _data.toList()

    fun addStudent(name: String, msv: String, studentClass: String){
        _data.add(
            Student(
                name = name,
                msv = msv,
                classroom = studentClass
            )
        )
    }

    fun updateStudent(name: String, studentClass: String, msv: String){
        val index = data.indexOf(data.find { it.msv == msv })
        _data[index] = data[index].copy(
            name = name,
            classroom = studentClass
        )
    }
}