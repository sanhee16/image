package com.sandy.mypicture

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sandy.mypicture.databinding.ItemImageBinding

class ImageAdapter (private val context: Context, private val dataList : ArrayList<ImageInfo>) :
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.v("TAG", "onCreateViewHolder")
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = ViewHolder(binding)
        return holder
    }

    override fun getItemCount(): Int {
        Log.v("TAG", "getItemCount")
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.v("TAG", "onBindViewHolder")
        holder.bind(dataList[position], context)
    }
    class ViewHolder(binding:ItemImageBinding)
        :RecyclerView.ViewHolder(binding.root){
        val binding = binding
        fun bind(image:ImageInfo, context: Context){
            Glide.with(context)
                .load(image.url)
                .into(binding.itemImage)
        }
    }
}