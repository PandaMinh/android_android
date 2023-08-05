package com.example.demokotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demokotlin.databinding.ItemStudentBinding

class StudentAdapter: ListAdapter<Student, StudentAdapter.StudentViewHolder>(studentDiffUtil()){

    class StudentViewHolder(val binding: ItemStudentBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemStudentBinding.inflate(inflater, parent, false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.binding.textViewItemStudentName.text = getItem(position).name
        holder.binding.textViewItemStudentMsv.text = getItem(position).msv
        holder.binding.textViewItemStudentClassroom.text = getItem(position).classroom
    }

    companion object{
        private fun studentDiffUtil() = object : DiffUtil.ItemCallback<Student>() {
            override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean =
                oldItem.msv == newItem.msv

            override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean =
                oldItem == newItem
        }
    }
}
