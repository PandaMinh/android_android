package com.example.demokotlin.student

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demokotlin.databinding.FragmentStudentManagementBinding


class StudentManagementFragment : Fragment() {
    private lateinit var binding: FragmentStudentManagementBinding
    private val viewModel: StudentManagementViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentManagementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val studentAdapter = StudentAdapter()

        binding.buttonStudentManagementAdd.setOnClickListener {
            viewModel.addStudent(
                binding.editTextStudentManagementName.text.toString(),
                binding.editTextStudentManagementMsv.text.toString(),
                binding.editTextStudentManagementClass.text.toString()
            )
        }

        binding.buttonStudentManagementUpdate.setOnClickListener {
            viewModel.updateStudent(
                binding.editTextStudentManagementName.text.toString(),
                binding.editTextStudentManagementClass.text.toString(),
                binding.editTextStudentManagementMsv.text.toString()
            )
        }

        binding.recyclerViewStudent.apply {
            adapter = studentAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

}