package com.sandy.mypicture

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sandy.mypicture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this@MainActivity

        Log.v("TAG", "MainActivity")
        val data = arrayListOf<ImageInfo>()
        data.add(ImageInfo(1,"image1","https://cdn.pixabay.com/photo/2021/10/19/10/56/cat-6723256_960_720.jpg"))
        data.add(ImageInfo(2,"image2","https://cdn.pixabay.com/photo/2014/04/13/20/49/cat-323262_960_720.jpg"))
        data.add(ImageInfo(3,"image3","https://cdn.pixabay.com/photo/2016/10/31/14/55/rottweiler-1785760_960_720.jpg"))
        data.add(ImageInfo(4,"image4","https://cdn.pixabay.com/photo/2016/01/05/17/51/maltese-1123016_960_720.jpg"))
        data.add(ImageInfo(5,"image5","https://cdn.pixabay.com/photo/2019/08/07/14/11/dog-4390885_960_720.jpg"))
        data.add(ImageInfo(6,"image6","https://cdn.pixabay.com/photo/2017/08/01/09/04/dog-2563759_960_720.jpg"))
        data.add(ImageInfo(7,"image6","https://cdn.pixabay.com/photo/2019/07/30/05/53/dog-4372036_960_720.jpg"))
        data.add(ImageInfo(8,"image6","https://cdn.pixabay.com/photo/2014/08/21/14/51/dog-423398_960_720.jpg"))

        imageAdapter = ImageAdapter(this, data)
        binding.imageRecycler.adapter = imageAdapter
        binding.imageRecycler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        imageAdapter.notifyDataSetChanged()
    }
}