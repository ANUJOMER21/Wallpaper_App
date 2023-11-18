package com.example.wallpaperapp.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.wallpaperapp.Repository.Model.WallpaperT
import com.example.wallpaperapp.Repository.RoomDb.FavEntity
import com.example.wallpaperapp.Repository.RoomDb.FavRepository

import com.example.wallpaperapp.Repository.WallpaperRepository
import kotlinx.coroutines.launch

class WallpaperGridViewModel(app:Application):AndroidViewModel(app) {
    private val repository=WallpaperRepository()
     private  val fav_repository=FavRepository(app);

       var wallpapers: ArrayList<WallpaperT>? =null;
    private val clickEvent = MutableLiveData<Int>()
    val clickEventLiveData: LiveData<Int> = clickEvent
     val fav_wallpapers=fav_repository.getAllFavs();

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
    fun favWallpaper(){
        viewModelScope.launch{
            try {
                wallpapers=ArrayList()
                fav_wallpapers.value!!.forEach{
                    wallpapers!!.add(WallpaperT(url=it.wall_url, category = 0, id = it.wall_id.toInt()))
                }
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
    fun favclicked(id: Int, url: String, fav: Int){
Log.d("favourite","$id | $fav")
        if(fav==0){
            fav_repository.insert(favEntity = FavEntity(id.toString(),url,id))
        }
        else{
            fav_repository.delete(favEntity = FavEntity(id.toString(),url,id))
        }


    }

    fun clicked(id: Int) {
       clickEvent.value=id;

    }


}
