package com.example.wallpaperapp.Screens.WallpaperGridScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.wallpaperapp.R

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun WallpaperThumnail(
    painter: Painter,
    contentDescription: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit, // Add a click listener as a parameter
    intialfav:Int,
    onFavClick:(Int )->Unit

) {
    var fav by remember {
        mutableIntStateOf(intialfav)
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp),
        shape = RoundedCornerShape(15.dp),
        onClick = onClick // Add an onClick parameter to the Card
    ) {
        Box(modifier = Modifier.height(250.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
            Icon(modifier= Modifier
                .align(Alignment.BottomEnd)
                .padding(10.dp)
                .clickable {
                    onFavClick(fav)
                    fav = if (fav == 0) 1 else 0 // Toggle the favorite state

                },

                painter= painterResource(id = if(fav==0) R.drawable.hearts_poker_svgrepo_com else R.drawable.hearts_game_svgrepo_com) ,
                contentDescription ="",
                tint= Color.Red

                )
        }
    }
}
