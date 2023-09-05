package com.example.demokotlin.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demokotlin.databinding.ItemPostsBinding

class PostsAdapter: ListAdapter<Posts, PostsAdapter.PostsViewHolder>(postsDiffUntil()){

    class PostsViewHolder(val binding: ItemPostsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPostsBinding.inflate(inflater, parent, false)
        return PostsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.binding.textViewItemPostsTitle.text = getItem(position).title
        holder.binding.textViewItemPostsBody.text = getItem(position).body
    }

    companion object{
        private fun postsDiffUntil() = object : DiffUtil.ItemCallback<Posts>(){
            override fun areItemsTheSame(oldItem: Posts, newItem: Posts): Boolean = oldItem.title == newItem.title
            override fun areContentsTheSame(oldItem: Posts, newItem: Posts): Boolean = oldItem == newItem
        }
    }
}

