package com.example.demokotlin.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.demokotlin.R
import com.example.demokotlin.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.forgot.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgotPassword_Fragment)
        }

        binding.newaccount.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_newAccount_Fragment)
        }

        binding.login.setOnClickListener {

        }

    }
}