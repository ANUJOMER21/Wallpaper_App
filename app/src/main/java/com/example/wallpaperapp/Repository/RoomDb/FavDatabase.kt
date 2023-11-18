package com.example.wallpaperapp.Repository.RoomDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.wallpaperapp.Repository.utils.subscribeOnBackground

@Database(entities = [FavEntity::class], version = 4)
abstract class FavDatabase :RoomDatabase()
{
        abstract  fun favDai():FavDao
        companion object{
            private  var instance:FavDatabase?=null
            @Synchronized
            fun getInstance(ctx:Context):FavDatabase{
                if(instance==null) {
                    instance = Room.databaseBuilder(
                        ctx.applicationContext, FavDatabase::class.java,
                        "fav_database"
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(roomCallback)
                        .build()
                }
                return instance!!
            }
            private  val  roomCallback=object :Callback(){
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    populateDatabase(instance!!)
                }
                private fun populateDatabase(db: FavDatabase) {



                }
            }
        }
}