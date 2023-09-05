package com.example.demokotlin.posts

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("app:postsList")
fun updatePosts(recyclerView: RecyclerView?, studentList: List<Posts>?){
    if (recyclerView?.adapter != null && ListPosts != null) {
        (recyclerView.adapter as? ListAdapter<Posts, *>)?.submitList(ListPosts)
    }
}