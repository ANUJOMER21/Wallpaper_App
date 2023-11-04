package com.example.wallpaperapp.Activity


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.wallpaperapp.BottomNavigation.BottomBar
import com.example.wallpaperapp.BottomNavigation.BottomNavigationScreens
import com.example.wallpaperapp.CategoryScreen.Categoryscreen
import com.example.wallpaperapp.FavouriteScreen.favouritescreen
import com.example.wallpaperapp.Profilescreen.profilescreen
import com.example.wallpaperapp.ViewModel.WallpaperGridViewModel
import com.example.wallpaperapp.WallpaperGridScreen.WallpaperGrid
import com.example.wallpaperapp.ui.theme.WallpaperAppTheme


class MainActivity : ComponentActivity() {
    private val WallpaperGridViewModel: WallpaperGridViewModel by viewModels()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            //  val toastMessage =viewModel.toastMessage

         WallpaperAppTheme {
             val navController: NavHostController = rememberNavController()
             val bottomBarHeight = 56.dp
             val bottomBarOffsetHeightPx = remember { mutableStateOf(0f) }

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


    }
    @Composable
    fun NavigationGraph(navController: NavHostController){
        NavHost(navController = navController, startDestination = BottomNavigationScreens.wallpapers.route){
composable(BottomNavigationScreens.wallpapers.route){
    WallpaperGrid(viewModel = WallpaperGridViewModel)
}
            composable(BottomNavigationScreens.category.route){
           Categoryscreen()
            }
            composable(BottomNavigationScreens.favourite.route){
                favouritescreen()
            }
            composable(BottomNavigationScreens.profile.route){
                profilescreen()
            }
        }
    }

}
