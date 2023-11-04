package com.example.wallpaperapp.WallpaperGridScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.wallpaperapp.ViewModel.WallpaperGridViewModel

@Composable
fun WallpaperGrid(viewModel: WallpaperGridViewModel
                  ) {
    viewModel.fetchWallpapers()
   val wallpapers= viewModel.wallpapers

  /*  LaunchedEffect(Unit) {

        viewModel.fetchWallpapers()
        viewModel.wallpapers
    }*/
    Column {

        if (wallpapers != null) {
            if(wallpapers.isEmpty()){
                Text(text = "No Wallpapers")
            }
            else{


                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 128.dp),
                    contentPadding = PaddingValues(
                        start = 12.dp,
                        top = 16.dp,
                        end = 12.dp,
                        bottom = 16.dp
                    ),
                    content = {
                            items(wallpapers) {
                                val painter=
                                    rememberImagePainter(data = it.url)

                                WallpaperThumnail(painter = painter, contentDescription =it.category, modifier = Modifier.fillMaxSize(), onClick = {
                                    viewModel.clicked(it.id)
                                })


                            }
                    }
                )
            }

        }
        else{
            Text(text = "Null")
        }
    }
            
}