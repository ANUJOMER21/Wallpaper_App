package com.example.wallpaperapp.Repository.RoomDb

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.wallpaperapp.Repository.utils.subscribeOnBackground

class FavRepository(application:Application) {
    private lateinit var noteDao: FavDao
    private lateinit var allNotes: LiveData<List<FavEntity>>

    private val database = FavDatabase.getInstance(application)
     init {
         noteDao=database.favDai();
         allNotes=noteDao.getAllNotes()
     }
    fun  insert(favEntity: FavEntity){
        subscribeOnBackground {
            noteDao.insert(favEntity)
        }
    }
    fun delete(favEntity: FavEntity){
        subscribeOnBackground {
            noteDao.delete(favEntity)
        }
    }
fun getAllFavs():LiveData<List<FavEntity>>{
    return  allNotes
}
}