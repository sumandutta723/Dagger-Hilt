package com.suman.dagger_hilt.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.suman.dagger_hilt.Model.Post
import com.codingwithjks.dagger_hilt.R

class PostAdapter(private val context:Context, private var postList: ArrayList<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
      return  PostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
       val post=postList[position]
        holder.name.text=post.name
    }

    override fun getItemCount(): Int = postList.size
    class PostViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)
    {
        val name:TextView=itemView.findViewById(R.id.name)
    }

    fun setData(postList: ArrayList<Post>)
    {
        this.postList=postList
        notifyDataSetChanged()
    }
}