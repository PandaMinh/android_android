package com.example.demokotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demokotlin.databinding.FragmentStudentManagementBinding


class StudentManagementFragment : Fragment() {
    private lateinit var binding: FragmentStudentManagementBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     binding = FragmentStudentManagementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = mutableListOf<Student>()
        val studentAdapter = StudentAdapter()

        binding.buttonStudentManagementAdd.setOnClickListener {
            data.add(Student(
                binding.editTextStudentManagementName.text.toString(),
                binding.editTextStudentManagementMsv.text.toString(),
                binding.editTextStudentManagementClass.text.toString()
            ))
            studentAdapter.submitList(data)
        }

        binding.buttonStudentManagementUpdate.setOnClickListener {
            data.find { it.msv == binding.editTextStudentManagementMsv.text.toString() } ?.let {
                it.name = binding.editTextStudentManagementName.text.toString()
                it.classroom = binding.editTextStudentManagementClass.text.toString()
            }
            studentAdapter.submitList(data)
        }

        binding.recyclerViewStudent.apply {
            adapter = studentAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

}