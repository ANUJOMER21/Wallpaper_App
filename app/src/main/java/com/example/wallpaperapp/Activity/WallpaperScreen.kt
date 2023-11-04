package com.example.wallpaperapp.Activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import com.example.wallpaperapp.R
import com.example.wallpaperapp.ViewModel.SingleWallpaperViewModel
import com.example.wallpaperapp.wallpaperSingleScreen.Wallpaper_view
import android.app.AlertDialog
import android.app.WallpaperManager
import android.content.Context
import android.content.DialogInterface
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.view.LayoutInflater
import android.view.View

import java.io.IOException
import java.io.InputStream
import java.net.URL
class WallpaperScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val viewModel:SingleWallpaperViewModel by viewModels()
        val wallId:Int?=intent.extras?.getInt("wallid")

        setContent {
           Wallpaper_view(viewModel = viewModel,wallId)


        }
        viewModel.clickEventLiveData.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            setWallpaperFromURL(it,WallpaperOption.HOME)
        }
    }


    private fun setWallpaperFromURL(imageUrl: String, option: WallpaperOption) {
        WallpaperAsyncTask(this, option).execute(imageUrl)
    }

    private inner class WallpaperAsyncTask(
        private val context: Context,
        private val option: WallpaperOption
    ) : AsyncTask<String, Void, Bitmap>() {

        override fun doInBackground(vararg params: String): Bitmap? {
            val imageUrl = params[0]

            try {
                val inputStream: InputStream = URL(imageUrl).openStream()
                return BitmapFactory.decodeStream(inputStream)
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return null
        }

        override fun onPostExecute(result: Bitmap?) {
            if (result != null) {
                try {
                    val wallpaperManager = WallpaperManager.getInstance(context)
                    when (option) {
                        WallpaperOption.HOME -> wallpaperManager.setBitmap(result, null, false, WallpaperManager.FLAG_SYSTEM)
                        WallpaperOption.LOCK -> wallpaperManager.setBitmap(result, null, false, WallpaperManager.FLAG_LOCK)
                        WallpaperOption.BOTH -> {
                            wallpaperManager.setBitmap(result, null, false, WallpaperManager.FLAG_SYSTEM)
                            wallpaperManager.setBitmap(result, null, false, WallpaperManager.FLAG_LOCK)
                        }
                    }
                    Toast.makeText(context, "Wallpaper set successfully!", Toast.LENGTH_SHORT).show()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            } else {
                Toast.makeText(context, "Failed to load wallpaper", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

enum class WallpaperOption {
    HOME, LOCK, BOTH
}



