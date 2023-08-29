package com.example.demokotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.demokotlin.data.API
import com.example.demokotlin.data.LoginRequest
import com.example.demokotlin.databinding.FragmentLoginBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
            val email = binding.phoneEmail.text.toString()
            val password = binding.password.text.toString()
            val loginRequest = LoginRequest(
                email = email,
                password = password
            )
            val response = lifecycleScope.async{
                withContext(Dispatchers.IO){
                    API.authService.login(loginRequest)
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}