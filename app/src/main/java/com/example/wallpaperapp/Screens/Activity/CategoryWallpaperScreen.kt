package com.example.wallpaperapp.Screens.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.ImageLoader
import com.example.wallpaperapp.Screens.Activity.ui.theme.WallpaperAppTheme
import com.example.wallpaperapp.ViewModel.WallpaperGridViewModel
import com.example.wallpaperapp.Screens.WallpaperGridScreen.WallpaperGrid

class CategoryWallpaperScreen : ComponentActivity() {
   private val viewmodel:WallpaperGridViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val catID:Int?=intent.extras?.getInt("catid")

        setContent {
            WallpaperAppTheme {
                val imageLoader=  remember { ImageLoader.Builder(this).build() }
                // A surface container using the 'background' color from the theme
                if (catID != null) {
                    WallpaperGrid(viewmodel,imageLoader,2,catID)
                }
        }
    }
        viewmodel.clickEventLiveData.observe(this){
            val intent = Intent(this@CategoryWallpaperScreen, WallpaperScreen::class.java).apply {
                putExtra("wallid", it)
            }
            startActivity(intent)
        }
}


}