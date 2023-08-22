package com.example.demokotlin.student

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("app:studentList")
fun updateStudentList(recyclerView: RecyclerView?, studentList: List<Student>?){
    if (recyclerView?.adapter != null && studentList != null) {
        (recyclerView.adapter as? ListAdapter<Student, *>)?.submitList(studentList)
        Log.d("BindingAdapter", studentList.toString())
    }
}