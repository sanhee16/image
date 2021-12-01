package com.sandy.mypicture

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import java.net.URL


class LoadImage : AsyncTask<Void, Void, Bitmap>() {
    lateinit var url: URL
    override fun doInBackground(vararg p: Void?): Bitmap {
        return BitmapFactory.decodeStream(url.openStream())
    }
    override fun onPostExecute(result: Bitmap?) {
        super.onPostExecute(result)
    }
}