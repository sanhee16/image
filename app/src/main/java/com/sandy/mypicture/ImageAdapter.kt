package com.sandy.mypicture

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sandy.mypicture.databinding.ItemImageBinding
import java.net.URL

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
    // https://itmining.tistory.com/7
    // https://velog.io/@dlrmwl15/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%9B%B9%EC%97%90%EC%84%9C-%EC%9D%B4%EB%AF%B8%EC%A7%80-%EA%B0%80%EC%A0%B8%EC%98%A4%EA%B8%B0
    class ViewHolder(binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding = binding
        private lateinit var loadImage : LoadImage
        fun bind(image: ImageInfo, context: Context) {
            // 1. use Glide
//            Glide.with(context)
//                .load(image.url)
//                .apply(RequestOptions.bitmapTransform(RoundedCorners(55)))
//                .into(binding.itemImage)
            
            // 2. use asyncTask
            loadImage = LoadImage()
            loadImage.url = URL(image.url)
            binding.itemImage.setImageBitmap(loadImage.execute().get())
        }
    }
}