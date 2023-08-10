package com.example.demokotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.demokotlin.databinding.FragmentHomeFacebookBinding

class HomeFacebookFragment : Fragment() {
    private var _binding: FragmentHomeFacebookBinding? = null
    private val binding: FragmentHomeFacebookBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeFacebookBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textViewHomeFBNewcontact.setOnClickListener {
            findNavController().navigate(R.id.action_homeFacebook_Fragment_to_contactFragment)
        }
    }
}