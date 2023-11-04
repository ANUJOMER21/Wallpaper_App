package com.example.wallpaperapp.BottomNavigation

import com.example.wallpaperapp.R

sealed class BottomNavigationScreens( val route: String,val title:String,val icon:Int){
    object wallpapers:BottomNavigationScreens("Wallpaper","Wallpapers", R.drawable.wallpaper_svgrepo_com)
    object category:BottomNavigationScreens("Category","Category", R.drawable.category_2_svgrepo_com)
    object favourite:BottomNavigationScreens("favourite","favourite", R.drawable.favorite_svgrepo_com)
    object profile:BottomNavigationScreens("Profile","Profile", R.drawable.user_svgrepo_com)

}
