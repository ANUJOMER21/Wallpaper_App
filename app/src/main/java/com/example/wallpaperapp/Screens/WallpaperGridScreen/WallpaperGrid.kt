package com.example.wallpaperapp.Screens.WallpaperGridScreen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberImagePainter
import com.example.wallpaperapp.R
import com.example.wallpaperapp.ViewModel.WallpaperGridViewModel

@Composable
fun WallpaperGrid(viewModel: WallpaperGridViewModel,imageLoader: ImageLoader,type:Int,catid:Int) {
    // type =1 main wallpaper
    if(type==1)viewModel.fetchWallpapers()
    else viewModel.fetchCategoryWallpapers(catid)

    val wallpapers = viewModel.wallpapers
    Log.d("Wallpaper_size","type $type | size ${wallpapers?.size}")

    Column {
        if (wallpapers != null) {
            if (wallpapers.isEmpty()) {
                Text(text = "No Wallpapers")
            } else {
                LazyVerticalGrid(

                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(
                        start = 12.dp,
                        top = 16.dp,
                        end = 12.dp,
                        bottom = 16.dp
                    ),
                    content = {
                        items(wallpapers) { wallpaper ->
                            val painter = rememberImagePainter(
                                data = wallpaper.url,
                                imageLoader = imageLoader,
                                builder = {
                                    crossfade(true)
                                    placeholder(R.drawable.placeholder) // Replace with your placeholder image
                                    error(R.drawable.error_svgrepo_com) // Replace with your error image
                                }
                            )

                            WallpaperThumnail(
                                painter = painter,
                                contentDescription = "",
                                modifier = Modifier.fillMaxSize(),
                                onClick = {
                                    viewModel.clicked(wallpaper.id)
                                },
                                0
                            )
                        }
                    }
                )
            }
        } else {
            Text(text = "Null")
        }
    }
}
