package com.example.wallpaperapp.wallpaperSingleScreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.wallpaperapp.R
import com.example.wallpaperapp.ViewModel.SingleWallpaperViewModel

@Composable
fun Wallpaper_view (viewModel: SingleWallpaperViewModel, wallId: Int?){
    viewModel.wallpaper(wallId)
    val wallpaperT=viewModel.wallpaper
    Log.d("wallpaper",(wallpaperT==null).toString())
    val painter= rememberImagePainter(data =wallpaperT?.url)
    if(wallpaperT!=null) {
        Box(
            modifier = Modifier.fillMaxSize(), // Use fillMaxSize to make the Box take up the entire screen
        ) {
            Image(
                painter = painter,
                contentDescription = wallpaperT.category,
                contentScale = ContentScale.FillBounds, modifier = Modifier.fillMaxSize()
            )

            Column(modifier = Modifier.align(Alignment.BottomEnd)) {
                Image(
                    painter = rememberImagePainter(R.drawable.download_square_svgrepo_com),
                    contentDescription = null,
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                        .padding(20.dp)
                        .clickable {
                            viewModel.click(wallpaperT.url)
                        }

                )


            }

        }
    }
    else {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = "Sorry, Image Not Loaded", modifier = Modifier.align(Alignment.Center))
        }
    }


}


