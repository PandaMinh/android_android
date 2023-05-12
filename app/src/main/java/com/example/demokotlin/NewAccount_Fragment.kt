package com.example.demokotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.demokotlin.databinding.FragmentLoginBinding
import com.example.demokotlin.databinding.FragmentNewAccountBinding

class NewAccount_Fragment : Fragment() {
    private var _binding: FragmentNewAccountBinding? = null
    private val binding: FragmentNewAccountBinding get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonNewAccountBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.buttonNewAccountRegister.setOnClickListener {
            findNavController().navigate(R.id.action_newAccount_Fragment_to_homeFacebook_Fragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}