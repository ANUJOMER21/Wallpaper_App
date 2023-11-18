package com.example.wallpaperapp.Repository.RoomDb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fav_table")
data class FavEntity(val wall_id: String,
                     val wall_url:String,
                @PrimaryKey() val id: Int? = null)