package com.example.demokotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.demokotlin.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.forgot.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgotPassword_Fragment)
        }

        binding.newaccount.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_newAccount_Fragment)
        }

        binding.login.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_homeFacebook_Fragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}