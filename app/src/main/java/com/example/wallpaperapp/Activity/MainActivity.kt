package com.example.wallpaperapp.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.ui.tooling.preview.Preview
import com.example.wallpaperapp.ViewModel.WallpaperGridViewModel
import com.example.wallpaperapp.WallpaperGridScreen.WallpaperGrid
import com.example.wallpaperapp.ui.theme.WallpaperAppTheme


class MainActivity : ComponentActivity() {
private val viewModel:WallpaperGridViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          //  val toastMessage =viewModel.toastMessage

            WallpaperGrid(viewModel=viewModel)

                }
        viewModel.clickEventLiveData.observe(this) {
            val intent = Intent(this@MainActivity, WallpaperScreen::class.java).apply {
                putExtra("wallid", it)
            }
            startActivity(intent)
        }


    }

        }






@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WallpaperAppTheme {

    }
}