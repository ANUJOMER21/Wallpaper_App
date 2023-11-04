package com.example.wallpaperapp.ViewModel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpaperapp.Model.WallpaperT
import com.example.wallpaperapp.Repository.WallpaperRepository
import kotlinx.coroutines.launch

class SingleWallpaperViewModel:ViewModel() {
    private val repository=WallpaperRepository()
    private val clickEvent = MutableLiveData<String>()
    val clickEventLiveData: LiveData<String> = clickEvent

    var wallpaper:WallpaperT?=null
     fun wallpaper(wallid: Int?) {
         viewModelScope.launch {
             try {
                 wallpaper= wallid?.let { repository.getSingleWallpaper(it) }
                 Log.d("wall_id", wallpaper?.category.toString())
             }catch (e:Exception){
                 Log.e("Exception ",e.toString())
             }
         }

    }

    fun click(url:String){
       clickEvent.value=url
    }

}