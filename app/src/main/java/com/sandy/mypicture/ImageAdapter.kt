package com.sandy.mypicture

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.sandy.mypicture.databinding.ItemImageBinding

class ImageAdapter(private val context: Context, private val dataList: ArrayList<ImageInfo>) :
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

    // TODO: 2021-11-23 glide를 사용하지 않고 AsyncTask를 사용해서 output 똑같이 띄우기
    class ViewHolder(binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding = binding
        fun bind(image: ImageInfo, context: Context) {
            Glide.with(context)
                .load(image.url)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(55)))
                .into(binding.itemImage)
        }
    }
}