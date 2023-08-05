package com.example.demokotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demokotlin.databinding.ItemContactBinding

class ContactAdapter(val data: List<Contact>): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    class ContactViewHolder(val binding: ItemContactBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemContactBinding.inflate(inflater, parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.binding.textViewItemContactName.text = data[position].name
        holder.binding.textViewItemContactPhoneNumber.text = data[position].phoneNumber
    }

    override fun getItemCount() = data.size
}