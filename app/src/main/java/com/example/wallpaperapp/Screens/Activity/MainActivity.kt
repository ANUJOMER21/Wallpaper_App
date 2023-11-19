package com.example.wallpaperapp.Screens.Activity


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import coil.ImageLoader
import coil.imageLoader
import com.example.wallpaperapp.Repository.Model.WallpaperT


import com.example.wallpaperapp.Screens.BottomNavigation.BottomBar
import com.example.wallpaperapp.Screens.BottomNavigation.BottomNavigationScreens
import com.example.wallpaperapp.Screens.CategoryRowScreen.categoryGrid

import com.example.wallpaperapp.Screens.Profilescreen.profilescreen
import com.example.wallpaperapp.ViewModel.CategoryViewModel
import com.example.wallpaperapp.ViewModel.WallpaperGridViewModel
import com.example.wallpaperapp.Screens.WallpaperGridScreen.WallpaperGrid

import com.example.wallpaperapp.ui.theme.WallpaperAppTheme


class MainActivity : ComponentActivity() {
    private val WallpaperGridViewModel: WallpaperGridViewModel by viewModels()
    private val CategoryViewModel:CategoryViewModel by viewModels()


    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)



        setContent {

         WallpaperAppTheme {
             val navController: NavHostController = rememberNavController()
            var buttonsVisible = remember { mutableStateOf(true) }
                        Scaffold(
                            bottomBar ={
                                BottomBar(
                                    navController = navController,
                                    state = buttonsVisible,
                                    modifier = Modifier
                                )
                            }
                        ) {paddingValues ->
                            Box( modifier = Modifier.padding(paddingValues)){
                                NavigationGraph(navController = navController)

                            }

                        }
         }


        }
        WallpaperGridViewModel.clickEventLiveData.observe(this) {
            val intent = Intent(this@MainActivity, WallpaperScreen::class.java).apply {
                putExtra("wallid", it)
            }
            startActivity(intent)
        }


        CategoryViewModel.clickEventLiveData.observe(this){
            val intent=Intent(this@MainActivity, CategoryWallpaperScreen::class.java).apply {
                putExtra("catid",it)
            }
            startActivity(intent)
        }


    }

    @SuppressLint("CoroutineCreationDuringComposition")
    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun NavigationGraph(navController: NavHostController){
        val imageLoader=  remember { ImageLoader.Builder(this@MainActivity).build() }
        NavHost(navController = navController, startDestination = BottomNavigationScreens.wallpapers.route){
            composable(BottomNavigationScreens.wallpapers.route){
                WallpaperGrid(viewModel = WallpaperGridViewModel,imageLoader,type=1, catid = 0)
            }
            composable(BottomNavigationScreens.category.route){
               categoryGrid(viewModel = CategoryViewModel, imageLoader = imageLoader)
            }
            composable(BottomNavigationScreens.profile.route){
                profilescreen()
            }
        }
    }

}
