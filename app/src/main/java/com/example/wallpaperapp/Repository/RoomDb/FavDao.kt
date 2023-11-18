package com.example.wallpaperapp.Repository.RoomDb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface FavDao {

    @Insert
    fun insert(fav: FavEntity)

    @Update
    fun update(fav: FavEntity)

    @Delete
    fun delete(fav: FavEntity)

    @Query("delete from fav_table")
    fun deleteAllNotes()

    @Query("select * from fav_table order by wall_id desc")
    fun getAllNotes(): LiveData<List<FavEntity>>
}