package com.example.demokotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demokotlin.databinding.FragmentContactBinding

class ContactFragment : Fragment() {
    private lateinit var binding: FragmentContactBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = mutableListOf<Contact>()

        binding.buttonNewContactAdd.setOnClickListener {
            data.add(Contact(
                binding.editTextNewContactPhone.text.toString(),
                binding.editTextNewContactName.text.toString()
            ))
            binding.recyclerViewContact.adapter = ContactAdapter(data)
        }
        binding.recyclerViewContact.apply {
            adapter = ContactAdapter(data)
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}