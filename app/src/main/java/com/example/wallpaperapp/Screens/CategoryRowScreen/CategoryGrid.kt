package com.example.wallpaperapp.Screens.CategoryRowScreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberImagePainter
import com.example.wallpaperapp.R
import com.example.wallpaperapp.ViewModel.CategoryViewModel

@OptIn(ExperimentalMaterialApi::class)
@RequiresApi(Build.VERSION_CODES.O)

@Composable
fun categoryGrid(
    viewModel:CategoryViewModel,imageLoader: ImageLoader
){
    viewModel.fetchCategories()
    val categories=viewModel.Categories

    Column {
        if(categories!=null){
            if(categories.isEmpty()){
                Text(text = "No categories")
            }
            else{
                LazyColumn(content = {
                    items(categories){
                        category->
                        val painter= rememberImagePainter(
                            data=category.firsturl,
                            imageLoader=imageLoader,
                            builder={
                                crossfade(true)
                                placeholder(R.drawable.placeholder) // Replace with your placeholder image
                                error(R.drawable.error_svgrepo_com) // Replace with your error image

                            }

                        )
                        CategoryThumbnail(painter = painter, type =category.type ) {
                               viewModel.clicked(category.catID)
                        }


                    }
                }
                )
            }
        }
        else{
            androidx.compose.material3.Text(text = "Null")
        }
    }


}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategoryThumbnail(painter: Painter,type:String,onClick:()->Unit){
    Card(
        onClick=onClick,
        Modifier
            .padding(10.dp),
        shape = RoundedCornerShape(15.dp),

        ) {
        Box(Modifier.height(150.dp)){
            Image(
                painter = painter,
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,
            )
            val offset = Offset(10.0f, 20.0f)
            Text(text = type,
                Modifier
                    .align(Alignment.BottomStart)
                    .padding(10.dp),
                color= Color.White,
                style= androidx.compose.ui.text.TextStyle(
                    letterSpacing = 2.sp,
                    fontSize = 24.sp,
                    shadow = Shadow(
                        color = Color.Black, offset = offset, blurRadius = 3f
                    )
                ),
                fontWeight = FontWeight.Bold,

                )
        }
    }
}
