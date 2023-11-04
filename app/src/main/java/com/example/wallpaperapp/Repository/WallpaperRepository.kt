package com.example.wallpaperapp.Repository

import android.util.Log
import com.example.wallpaperapp.Model.WallpaperT

class WallpaperRepository {
    suspend fun getWallpapers():ArrayList<WallpaperT>{
        val wallpapers:ArrayList<WallpaperT> = ArrayList<WallpaperT>();
        wallpapers.add(WallpaperT("https://images.unsplash.com/photo-1698793915908-6f0218c4aafd?auto=format&fit=crop&q=60&w=900&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw0fHx8ZW58MHx8fHx8",
            "Mountain",
            1))
        wallpapers.add(WallpaperT("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQSFVTZZq0VJfzWFcfUdWIOx7X7yR-ha5W39m0tgdwNXXoV1EDa1-_Q-dPYL1JV",
            "Mountain",
            2))

        wallpapers.add(WallpaperT("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQ1S7itmCxDedWouptWSohMLWm16wgFWLXFKcPN9OGL_A5vwKyBtaAmL7fX_TWF",
            "Mountain",
            3))

        wallpapers.add(WallpaperT("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSP-7s-3Kv3UOPMc6tSm6pOE0mVs1WwKMfbdv_gIL11DKnoIPWyyisZhRQmpNjE" ,
                       "Mountain",
            4))

        wallpapers.add(WallpaperT("https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQ8jKr9uFozOGYHDtfN4MMxbVcgOG7wSCmUCAg0pGrsExLnng7lHt3-_FIFwb2J",
            "Mountain",
            5))

        wallpapers.add(WallpaperT("https://images.unsplash.com/photo-1549880181-56a44cf4a9a5?auto=format&fit=crop&q=60&w=900&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fG1vdW50YWlufGVufDB8fDB8fHww",
            "Mountain",
            6))
        wallpapers.add(WallpaperT("https://images.unsplash.com/photo-1698793915908-6f0218c4aafd?auto=format&fit=crop&q=60&w=900&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw0fHx8ZW58MHx8fHx8",
            "Mountain",
            7))
        wallpapers.add(WallpaperT("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQSFVTZZq0VJfzWFcfUdWIOx7X7yR-ha5W39m0tgdwNXXoV1EDa1-_Q-dPYL1JV",
            "Mountain",
            8))

        wallpapers.add(WallpaperT("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQ1S7itmCxDedWouptWSohMLWm16wgFWLXFKcPN9OGL_A5vwKyBtaAmL7fX_TWF",
            "Mountain",
            9))

        wallpapers.add(WallpaperT("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSP-7s-3Kv3UOPMc6tSm6pOE0mVs1WwKMfbdv_gIL11DKnoIPWyyisZhRQmpNjE" ,
            "Mountain",
            10))

        wallpapers.add(WallpaperT("https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQ8jKr9uFozOGYHDtfN4MMxbVcgOG7wSCmUCAg0pGrsExLnng7lHt3-_FIFwb2J",
            "Mountain",
            11))

        wallpapers.add(WallpaperT("https://images.unsplash.com/photo-1549880181-56a44cf4a9a5?auto=format&fit=crop&q=60&w=900&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fG1vdW50YWlufGVufDB8fDB8fHww",
            "Mountain",
            12))
        return wallpapers;
    }
    suspend fun getSingleWallpaper(wllId:Int): WallpaperT? {
var wallpaperT:WallpaperT?=null
        for(w in getWallpapers()){
            Log.d("wall_loop","${w.id.toString()}| $wllId")
         if(w.id==wllId){
             wallpaperT=w;
         }
        }
      return wallpaperT;
    }
}