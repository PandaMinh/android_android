package com.example.demokotlin

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.demokotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
//        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.login.setOnClickListener {
            when (binding.password.transformationMethod) {
                PasswordTransformationMethod.getInstance() -> {
                    binding.password.transformationMethod =
                        HideReturnsTransformationMethod.getInstance()
                }
                HideReturnsTransformationMethod.getInstance() -> {
                    binding.password.transformationMethod =
                        PasswordTransformationMethod.getInstance()
                }
            }
        }
    }
}