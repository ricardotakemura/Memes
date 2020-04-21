package br.net.takemura.ricardo.memes.view.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import java.net.URL

class ImageViewUtil {
    private class BitMapAsyncTask(private val imageView: ImageView): AsyncTask<URL, Void, Bitmap?>() {
        override fun doInBackground(vararg params: URL): Bitmap? {
            if (params.size == 1) {
                return BitmapFactory.decodeStream(params[0].openStream())
            }
            return null
        }

        override fun onPostExecute(result: Bitmap?) {
            super.onPostExecute(result)
            imageView.setImageBitmap(result)
        }
    }

    private var bitMapAsyncTask: BitMapAsyncTask? = null

    fun loadAsyncImageURL(imageView: ImageView, url: URL) {
        imageView.setImageBitmap(Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8))
        bitMapAsyncTask?.cancel(true)
        bitMapAsyncTask = BitMapAsyncTask(imageView)
        bitMapAsyncTask?.execute(url)
    }
}