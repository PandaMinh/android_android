package com.example.demokotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.demokotlin.databinding.FragmentNewAccountBinding
import com.example.demokotlin.databinding.FragmentNewContactBinding


class NewContactFragment : Fragment() {
    private var _binding: FragmentNewContactBinding? = null
    private val binding: FragmentNewContactBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonNewContactAdd.setOnClickListener {
            binding.editTextNewContactPhone.text
            binding.editTextNewContactName.text
            findNavController().navigate(R.id.action_newContactFragment_to_contactFragment)
        }
    }

}