package com.example.wallpaperapp.ViewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpaperapp.Repository.Model.WallpaperT
import com.example.wallpaperapp.Repository.WallpaperRepository
import kotlinx.coroutines.launch

class WallpaperGridViewModel:ViewModel() {
    private val repository=WallpaperRepository()
       var wallpapers: ArrayList<WallpaperT>? =null;

    private val clickEvent = MutableLiveData<Int>()
    val clickEventLiveData: LiveData<Int> = clickEvent
//ger wallpaper from repository

    fun fetchWallpapers(){
        viewModelScope.launch {
            try {
                 wallpapers=repository.getWallpapers()

            }
            catch (e:Exception){
                Log.e("Exception",e.toString())
            }
        }
    }
  fun  fetchCategoryWallpapers(catId:Int){
      viewModelScope.launch {
          try {
              wallpapers=repository.getCategoryWallpapers(catId)
          }
          catch (e:Exception){
              Log.e("Exception",e.toString())

          }
      }
  }


    fun clicked(id: Int) {
       clickEvent.value=id;

    }


}