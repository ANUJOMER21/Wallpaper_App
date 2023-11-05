package com.example.wallpaperapp.Repository

import android.util.Log
import com.example.wallpaperapp.Repository.Model.Category
import com.example.wallpaperapp.Repository.Model.WallpaperT

class WallpaperRepository {
    suspend fun getWallpapers():ArrayList<WallpaperT>{
        val wallpapers:ArrayList<WallpaperT> = ArrayList<WallpaperT>();
               val urls=Urls()
             for (pos in urls.indices){

                 val wallpaperT= WallpaperT(urls.get(pos),pos%16+1,pos)
                 wallpapers.add(wallpaperT)
             }


        return wallpapers;
    }
    suspend fun getCategoryWallpapers(cat_id:Int):ArrayList<WallpaperT>{
        val wallpapers=getWallpapers();
        val catwall:ArrayList<WallpaperT> =ArrayList()
  for (wallpaper in wallpapers){
      Log.d("cat_ID",wallpaper.category.toString())
      if(wallpaper.category==cat_id)catwall.add(wallpaper)
  }

        return catwall;
    }

    suspend fun getCategory():ArrayList<Category>{
        val wallpapers=getWallpapers();
        val Cateries=ArrayList<Category>();
        Cateries.add(Category("Nature",1,wallpapers.get(0).url))
        Cateries.add(Category("City",2,wallpapers.get(1).url))
        Cateries.add(Category("Animal",3,wallpapers.get(2).url))
        Cateries.add(Category("Landscape",4,wallpapers.get(3).url))
        Cateries.add(Category("Amoled",5,wallpapers.get(4).url))
        Cateries.add(Category("Dark",6,wallpapers.get(5).url))
        Cateries.add(Category("Anime",7,wallpapers.get(6).url))
        Cateries.add(Category("Cars",8,wallpapers.get(7).url))
        Cateries.add(Category("Sports",9,wallpapers.get(8).url))
        Cateries.add(Category("Space",10,wallpapers.get(9).url))
        Cateries.add(Category("SuperHeroes",11,wallpapers.get(10).url))
        Cateries.add(Category("Ios",12,wallpapers.get(11).url))
        Cateries.add(Category("Solid",13,wallpapers.get(12).url))
        Cateries.add(Category("Abstract",14,wallpapers.get(13).url))
        Cateries.add(Category("Shapes",15,wallpapers.get(14).url))
        Cateries.add(Category("Minimal",16,wallpapers.get(15).url))


        return Cateries;
    }
    private fun Urls():ArrayList<String>{
        val imageUrls = arrayListOf(
            "https://images.unsplash.com/photo-1610987039121-d70917dcc6f6?auto.format&fit=crop&q=80&w=1000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8d2FsbHBhcGVyJTIwZm9yJTIwbW9iaWxlfGVufDB8fDB8fHww",
            "https://images.unsplash.com/photo-1632739867170-41aeb7069615?auto.format&fit=crop&q=80&w=1000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8d2FsbHBhcGVyJTIwZm9yJTIwbW9iaWxlfGVufDB8fDB8fHww",
            "https://images.unsplash.com/photo-1619611191741-692703d71d51?auto.format&fit=crop&q=80&w=1000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTl8fHdhbGxwYXBlciUyMGZvciUyMG1vYmlsZXxlbnwwfHwwfHx8MA%3D%3D",
            "https://images.unsplash.com/photo-1621232082074-1a7750ecc557?auto.format&fit=crop&q=80&w=1000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fHdhbGxwYXBlciUyMGZvciUyMG1vYmlsZXxlbnwwfHwwfHx8MA%3D%3D",
            "https://images.unsplash.com/photo-1576106671236-0cb9f26137cd?auto.format&fit=crop&q=80&w=1000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8d2FsbHBhcGVyJTIwZm9yJTIwbW9iaWxlfGVufDB8fDB8fHww",
            "https://images.unsplash.com/photo-1628029799784-50d803e64ea0?auto.format&fit=crop&q=80&w=1000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTB8fHdhbGxwYXBlciUyMGZvciUyMG1vYmlsZXxlbnwwfHwwfHx8MA%3D%3D",
            "https://plus.unsplash.com/premium_photo-1673264931453-932b7ebba368?auto.format&fit=crop&q=80&w=1000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8d2FsbHBhcGVyJTIwZm9yJTIwbW9iaWxlfGVufDB8fDB8fHww",
            "https://images.unsplash.com/photo-1633879860828-30532d861528?auto.format&fit=crop&q=80&w=1000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTR8fHdhbGxwYXBlciUyMGZvciUyMG1vYmlsZXxlbnwwfHwwfHx8MA%3D%3D",
            "https://images.unsplash.com/photo-1611068813580-b07ef920964b?auto.format&fit=crop&q=80&w=1000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8d2FsbHBhcGVyJTIwZm9yJTIwbW9iaWxlfGVufDB8fDB8fHww",
            "https://plus.unsplash.com/premium_photo-1679969301936-9dbae1660aac?auto.format&fit=crop&q=80&w=1000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTd8fHdhbGxwYXBlciUyMGZvciUyMG1vYmlsZXxlbnwwfHwwfHx8MA%3D%3D",
            "https://images.unsplash.com/photo-1613661817926-6a57e65b4c5d?auto.format&fit=crop&q=80&w=1000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjB8fHdhbGxwYXBlciUyMGZvciUyMG1vYmlsZXxlbnwwfHwwfHx8MA",
            "https://plus.unsplash.com/premium_photo-1661573050371-3613493f70c4?auto.format&fit=crop&q=80&w=1000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8d2FsbHBhcGVyJTIwZm9yJTIwbW9iaWxlfGVufDB8fDB8fHww",
            "https://images.unsplash.com/photo-1622118141278-69f0539013b3?auto.format&fit=crop&q=80&w=1000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTJ8fHdhbGxwYXBlciUyMGZvciUyMG1vYmlsZXxlbnwwfHwwfHx8MA%3D%3D",
            "https://images.unsplash.com/photo-1610599083971-83a1abb23a56?auto.format&fit=crop&q=80&w=1000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTV8fHdhbGxwYXBlciUyMGZvciUyMG1vYmlsZXxlbnwwfHwwfHx8MA%3D%3D",
            "https://images.unsplash.com/photo-1612012460576-5d51b5b04b00?auto.format&fit=crop&q=80&w=1000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8d2FsbHBhcGVyJTIwZm9yJTIwbW9iaWxlfGVufDB8fDB8fHww",
            "https://images.unsplash.com/photo-1633879860828-30532d861528?auto.format&fit=crop&q=60&w=500&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTR8fHdhbGxwYXBlciUyMGZvciUyMG1vYmlsZXxlbnwwfHwwfHx8MA%3D%3D",
            "https://images.unsplash.com/photo-1611157817797-ed7184b2a12d?auto.format&fit=crop&q=60&w=500&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8d2FsbHBhcGVyJTIwZm9yJTIwbW9iaWxlfGVufDB8fDB8fHww",
            "https://plus.unsplash.com/premium_photo-1678935939751-803a0f890d6e?auto.format&fit=crop&q=60&w=500&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8d2FsbHBhcGVyJTIwZm9yJTIwbW9iaWxlfGVufDB8fDB8fHww",
            "https://plus.unsplash.com/premium_photo-1677556743433-8ace1c020781?auto.format&fit=crop&q=80&w=1000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTN8fHdhbGxwYXBlciUyMGZvciUyMG1vYmlsZXxlbnwwfHwwfHx8MA%3D%3D",
            "https://images.unsplash.com/photo-1613800172017-6b2b3787fdb8?auto.format&fit=crop&q=80&w=1000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fHdhbGxwYXBlciUyMGZvciUyMG1vYmlsZXxlbnwwfHwwfHx8MA%3D%3D",
            "https://images.unsplash.com/photo-1632739867170-41aeb7069615?auto.format&fit=crop&q=60&w=500&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8d2FsbHBhcGVyJTIwZm9yJTIwbW9iaWxlfGVufDB8fDB8fHww",
            "https://images.unsplash.com/photo-1576106671236-0cb9f26137cd?auto.format&fit=crop&q=60&w=500&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8d2FsbHBhcGVyJTIwZm9yJTIwbW9iaWxlfGVufDB8fDB8fHww",
            "https://images.unsplash.com/photo-1610987039121-d70917dcc6f6?auto.format&fit=crop&q=60&w=500&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8d2FsbHBhcGVyJTIwZm9yJTIwbW9iaWxlfGVufDB8fDB8fHww",
            "https://images.unsplash.com/photo-1619611191741-692703d71d51?auto.format&fit=crop&q=60&w=500&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTl8fHdhbGxwYXBlciUyMGZvciUyMG1vYmlsZXxlbnwwfHwwfHx8MA%3D%3D",
            "https://images.unsplash.com/photo-1621232082074-1a7750ecc557?auto.format&fit=crop&q=60&w=500&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fHdhbGxwYXBlciUyMGZvciUyMG1vYmlsZXxlbnwwfHwwfHx8MA%3D%3D",
            "https://images.pexels.com/photos/1906794/pexels-photo-1906794.jpeg?cs=srgb&dl=pexels-alessio-cesario-1906794.jpg&fm=jpg",
            "https://images.pexels.com/photos/1906794/pexels-photo-1906794.jpeg",
            "https://images.pexels.com/photos/1122639/pexels-photo-1122639.jpeg?cs=srgb&dl=pexels-irina-iriser-1122639.jpg&fm=jpg",
            "https://images.pexels.com/photos/1271620/pexels-photo-1271620.jpeg?cs=srgb&dl=pexels-andrei-tanase-1271620.jpg&fm=jpg",
            "https://images.pexels.com/photos/1526713/pexels-photo-1526713.jpeg?cs=srgb&dl=pexels-francesco-ungaro-1526713.jpg&fm=jpg",
            "https://images.pexels.com/photos/1366630/pexels-photo-1366630.jpeg?cs=srgb&dl=pexels-max-andrey-1366630.jpg&fm=jpg",
            "https://images.pexels.com/photos/1381679/pexels-photo-1381679.jpeg?cs=srgb&dl=pexels-irina-iriser-1381679.jpg&fm=jpg",
            "https://images.pexels.com/photos/1122639/pexels-photo-1122639.jpeg",
            "https://images.pexels.com/photos/1192330/pexels-photo-1192330.jpeg?cs=srgb&dl=pexels-lil-artsy-1192330.jpg&fm=jpg",
            "https://images.pexels.com/photos/1271620/pexels-photo-1271620.jpeg",
            "https://images.pexels.com/photos/1366630/pexels-photo-1366630.jpeg",
            "https://images.pexels.com/photos/1526713/pexels-photo-1526713.jpeg",
            "https://images.pexels.com/photos/1192330/pexels-photo-1192330.jpeg",
            "https://images.pexels.com/photos/1381679/pexels-photo-1381679.jpeg",
            "https://images.pexels.com/photos/235986/pexels-photo-235986.jpeg",
            "https://images.pexels.com/users/avatars/4672/kaique-rocha-608.jpeg",
            "https://images.pexels.com/photos/1391498/pexels-photo-1391498.jpeg",
            "https://images.pexels.com/photos/1784578/pexels-photo-1784578.jpeg?cs=srgb&dl=pexels-zetong-li-1784578.jpg&fm=jpg",
            "https://images.pexels.com/photos/1784578/pexels-photo-1784578.jpeg",
            "https://images.pexels.com/photos/1535162/pexels-photo-1535162.jpeg?cs=srgb&dl=pexels-todd-trapani-1535162.jpg&fm=jpg",
            "https://images.pexels.com/photos/1535162/pexels-photo-1535162.jpeg",
            "https://images.pexels.com/photos/1037992/pexels-photo-1037992.jpeg",
            "https://images.pexels.com/photos/3052361/pexels-photo-3052361.jpeg",
            "https://images.pexels.com/photos/1684151/pexels-photo-1684151.jpeg?cs=srgb&dl=pexels-daria-obymaha-1684151.jpg&fm=jpg",
            "https://images.pexels.com/photos/1684151/pexels-photo-1684151.jpeg",
            "https://images.pexels.com/photos/1257860/pexels-photo-1257860.jpeg?cs=srgb&dl=pexels-philippe-donn-1257860.jpg&fm=jpg",
            "https://images.pexels.com/photos/1257860/pexels-photo-1257860.jpeg",
            "https://images.pexels.com/photos/1906658/pexels-photo-1906658.jpeg?cs=srgb&dl=pexels-egil-sj%C3%B8holt-1906658.jpg&fm=jpg",
            "https://images.pexels.com/photos/1906658/pexels-photo-1906658.jpeg",
            "https://images.pexels.com/photos/1707215/pexels-photo-1707215.jpeg?cs=srgb&dl=pexels-irina-iriser-1707215.jpg&fm=jpg",
            "https://images.pexels.com/photos/1707215/pexels-photo-1707215.jpeg",
            "https://images.pexels.com/photos/4553036/pexels-photo-4553036.jpeg",
            "https://images.pexels.com/photos/1334116/pexels-photo-1334116.jpeg?cs=srgb&dl=pexels-irina-iriser-1334116.jpg&fm=jpg",
            "https://images.pexels.com/photos/1334116/pexels-photo-1334116.jpeg",
            "https://images.pexels.com/photos/1761279/pexels-photo-1761279.jpeg",
            "https://images.pexels.com/photos/1624438/pexels-photo-1624438.jpeg?cs=srgb&dl=pexels-eberhard-grossgasteiger-1624438.jpg&fm=jpg",
            "https://images.pexels.com/photos/2486168/pexels-photo-2486168.jpeg?cs=srgb&dl=pexels-roberto-nickson-2486168.jpg&fm=jpg",
            "https://images.pexels.com/photos/1367105/pexels-photo-1367105.jpeg?cs=srgb&dl=pexels-eberhard-grossgasteiger-1367105.jpg&fm=jpg",
            "https://images.pexels.com/photos/1624438/pexels-photo-1624438.jpeg",
            "https://images.pexels.com/photos/1367105/pexels-photo-1367105.jpeg",
            "https://images.pexels.com/photos/2486168/pexels-photo-2486168.jpeg",
            "https://images.pexels.com/photos/1668928/pexels-photo-1668928.jpeg",
            "https://images.pexels.com/photos/1415131/pexels-photo-1415131.jpeg",
            "https://images.pexels.com/photos/1097491/pexels-photo-1097491.jpeg?cs=srgb&dl=pexels-eberhard-grossgasteiger-1097491.jpg&fm=jpg",
            "https://images.pexels.com/photos/1097491/pexels-photo-1097491.jpeg",
            "https://images.pexels.com/photos/1020016/pexels-photo-1020016.jpeg?cs=srgb&dl=pexels-oliver-sj%C3%B6str%C3%B6m-1020016.jpg&fm=jpg",
            "https://images.pexels.com/photos/1020016/pexels-photo-1020016.jpeg",
            "https://images.pexels.com/photos/799443/pexels-photo-799443.jpeg?cs=srgb&dl=pexels-matheus-bertelli-799443.jpg&fm=jpg",
            "https://images.pexels.com/photos/799443/pexels-photo-799443.jpeg",
            "https://images.pexels.com/photos/1723637/pexels-photo-1723637.jpeg?cs=srgb&dl=pexels-brakou-abdelghani-1723637.jpg&fm=jpg",
            "https://images.pexels.com/photos/1212487/pexels-photo-1212487.jpeg?cs=srgb&dl=pexels-rahul-pandit-1212487.jpg&fm=jpg",
            "https://images.pexels.com/photos/21492/pexels-photo.jpg?cs=srgb&dl=pexels-bob-clark-21492.jpg&fm=jpg",
            "https://images.pexels.com/photos/1723637/pexels-photo-1723637.jpeg",
            "https://images.pexels.com/photos/1212487/pexels-photo-1212487.jpeg",
            "https://images.pexels.com/photos/21492/pexels-photo.jpg",
            "https://images.pexels.com/photos/1141792/pexels-photo-1141792.jpeg?cs=srgb&dl=pexels-dominika-roseclay-1141792.jpg&fm=jpg",
            "https://images.pexels.com/photos/1141792/pexels-photo-1141792.jpeg",
            "https://images.pexels.com/photos/775203/pexels-photo-775203.jpeg?cs=srgb&dl=pexels-kaique-rocha-775203.jpg&fm=jpg",
            "https://images.pexels.com/photos/1699020/pexels-photo-1699020.jpeg?cs=srgb&dl=pexels-eberhard-grossgasteiger-1699020.jpg&fm=jpg",
            "https://images.pexels.com/photos/775203/pexels-photo-775203.jpeg",
            "https://images.pexels.com/photos/1699020/pexels-photo-1699020.jpeg",
            "https://images.pexels.com/users/avatars/177895/matheus-bertelli-298.jpeg",
            "https://images.pexels.com/photos/1172849/pexels-photo-1172849.jpeg?cs=srgb&dl=pexels-jess-bailey-designs-1172849.jpg&fm=jpg",
            "https://images.pexels.com/photos/1172849/pexels-photo-1172849.jpeg",
            "https://images.pexels.com/photos/325044/pexels-photo-325044.jpeg?cs=srgb&dl=pexels-chevanon-photography-325044.jpg&fm=jpg",
            "https://images.pexels.com/photos/325044/pexels-photo-325044.jpeg",
            "https://images.pexels.com/photos/1585325/pexels-photo-1585325.jpeg?cs=srgb&dl=pexels-steve-johnson-1585325.jpg&fm=jpg",
            "https://images.pexels.com/photos/1585325/pexels-photo-1585325.jpeg",
            "https://images.pexels.com/photos/3294254/pexels-photo-3294254.jpeg",
            "https://images.pexels.com/photos/1420440/pexels-photo-1420440.jpeg?cs=srgb&dl=pexels-todd-trapani-1420440.jpg&fm=jpg",
            "https://images.pexels.com/photos/1420440/pexels-photo-1420440.jpeg",
            "https://images.pexels.com/photos/1624496/pexels-photo-1624496.jpeg?cs=srgb&dl=pexels-eberhard-grossgasteiger-1624496.jpg&fm=jpg",
            "https://images.pexels.com/photos/1624496/pexels-photo-1624496.jpeg",
            "https://images.pexels.com/photos/1767434/pexels-photo-1767434.jpeg",
            "https://images.pexels.com/photos/1226302/pexels-photo-1226302.jpeg?cs=srgb&dl=pexels-tausif-hossain-1226302.jpg&fm=jpg",
            "https://images.pexels.com/photos/1226302/pexels-photo-1226302.jpeg",
            "https://images.pexels.com/photos/931177/pexels-photo-931177.jpeg",
            "https://images.pexels.com/photos/1212600/pexels-photo-1212600.jpeg?cs=srgb&dl=pexels-sasha-martynov-1212600.jpg&fm=jpg",
            "https://images.pexels.com/photos/1212600/pexels-photo-1212600.jpeg",
            "https://images.pexels.com/photos/1253661/pexels-photo-1253661.jpeg?cs=srgb&dl=pexels-katarzyna-modrzejewska-1253661.jpg&fm=jpg",
            "https://images.pexels.com/photos/1253661/pexels-photo-1253661.jpeg",
            "https://images.pexels.com/photos/1078983/pexels-photo-1078983.jpeg?cs=srgb&dl=pexels-oliver-sj%C3%B6str%C3%B6m-1078983.jpg&fm=jpg",
            "https://images.pexels.com/photos/1078983/pexels-photo-1078983.jpeg",
            "https://images.pexels.com/photos/674010/pexels-photo-674010.jpeg",
            "https://images.pexels.com/photos/4065906/pexels-photo-4065906.jpeg",
            "https://images.pexels.com/photos/1156684/pexels-photo-1156684.jpeg?cs=srgb&dl=pexels-arun-thomas-1156684.jpg&fm=jpg",
            "https://images.pexels.com/photos/1156684/pexels-photo-1156684.jpeg",
            "https://images.pexels.com/users/avatars/488382/todd-trapani-852.jpeg",
            "https://images.pexels.com/photos/2098427/pexels-photo-2098427.jpeg?cs=srgb&dl=pexels-eberhard-grossgasteiger-2098427.jpg&fm=jpg",
            "https://images.pexels.com/photos/2098427/pexels-photo-2098427.jpeg",
            "https://images.pexels.com/photos/40465/pexels-photo-40465.jpeg?cs=srgb&dl=pexels-deepu-b-iyer-40465.jpg&fm=jpg",
            "https://images.pexels.com/photos/40465/pexels-photo-40465.jpeg",
            "https://images.pexels.com/photos/60597/dahlia-red-blossom-bloom-60597.jpeg?cs=srgb&dl=pexels-pixabay-60597.jpg&fm=jpg",
            "https://images.pexels.com/photos/60597/dahlia-red-blossom-bloom-60597.jpeg",
            "https://images.pexels.com/photos/1366913/pexels-photo-1366913.jpeg?cs=srgb&dl=pexels-eberhard-grossgasteiger-1366913.jpg&fm=jpg",
            "https://images.pexels.com/photos/1366913/pexels-photo-1366913.jpeg",
            "https://images.pexels.com/photos/33109/fall-autumn-red-season.jpg?cs=srgb&dl=pexels-pixabay-33109.jpg&fm=jpg",
            "https://images.pexels.com/photos/33109/fall-autumn-red-season.jpg",
            "https://images.pexels.com/photos/1545743/pexels-photo-1545743.jpeg",
            "https://images.pexels.com/photos/1598073/pexels-photo-1598073.jpeg?cs=srgb&dl=pexels-james-wheeler-1598073.jpg&fm=jpg",
            "https://images.pexels.com/photos/1598073/pexels-photo-1598073.jpeg",
            "https://images.pexels.com/photos/1105189/pexels-photo-1105189.jpeg?cs=srgb&dl=pexels-philippe-donn-1105189.jpg&fm=jpg",
            "https://images.pexels.com/photos/1105189/pexels-photo-1105189.jpeg",
            "https://images.pexels.com/photos/1366919/pexels-photo-1366919.jpeg?cs=srgb&dl=pexels-eberhard-grossgasteiger-1366919.jpg&fm=jpg",
            "https://images.pexels.com/photos/1366909/pexels-photo-1366909.jpeg?cs=srgb&dl=pexels-eberhard-grossgasteiger-1366909.jpg&fm=jpg",
            "https://images.pexels.com/photos/937980/pexels-photo-937980.jpeg?cs=srgb&dl=pexels-tetyana-kovyrina-937980.jpg&fm=jpg",
            "https://images.pexels.com/photos/1366919/pexels-photo-1366919.jpeg",
            "https://images.pexels.com/photos/937980/pexels-photo-937980.jpeg",
            "https://images.pexels.com/photos/1366909/pexels-photo-1366909.jpeg",
            "https://images.pexels.com/photos/1433052/pexels-photo-1433052.jpeg?cs=srgb&dl=pexels-oliver-sj%C3%B6str%C3%B6m-1433052.jpg&fm=jpg",
            "https://images.pexels.com/photos/1433052/pexels-photo-1433052.jpeg",
            "https://images.pexels.com/photos/719396/pexels-photo-719396.jpeg?cs=srgb&dl=pexels-gabriel-peter-719396.jpg&fm=jpg",
            "https://images.pexels.com/photos/719396/pexels-photo-719396.jpeg",
            "https://images.pexels.com/photos/1784578/pexels-photo-1784578.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1598073/pexels-photo-1598073.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1097491/pexels-photo-1097491.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/2098427/pexels-photo-2098427.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1366919/pexels-photo-1366919.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1624496/pexels-photo-1624496.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1212487/pexels-photo-1212487.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/799443/pexels-photo-799443.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1707215/pexels-photo-1707215.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1366630/pexels-photo-1366630.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1535162/pexels-photo-1535162.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1420440/pexels-photo-1420440.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1366913/pexels-photo-1366913.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/775203/pexels-photo-775203.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1723637/pexels-photo-1723637.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1122639/pexels-photo-1122639.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1624438/pexels-photo-1624438.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/2486168/pexels-photo-2486168.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/937980/pexels-photo-937980.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1367105/pexels-photo-1367105.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1906658/pexels-photo-1906658.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1271620/pexels-photo-1271620.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/719396/pexels-photo-719396.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1684151/pexels-photo-1684151.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1366909/pexels-photo-1366909.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1526713/pexels-photo-1526713.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1699020/pexels-photo-1699020.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1381679/pexels-photo-1381679.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1212600/pexels-photo-1212600.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1334116/pexels-photo-1334116.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1192330/pexels-photo-1192330.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1105189/pexels-photo-1105189.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1257860/pexels-photo-1257860.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1906794/pexels-photo-1906794.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1253661/pexels-photo-1253661.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1156684/pexels-photo-1156684.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/40465/pexels-photo-40465.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1226302/pexels-photo-1226302.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1141792/pexels-photo-1141792.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1172849/pexels-photo-1172849.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1078983/pexels-photo-1078983.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/users/avatars/794122/brakou-abdelghani-950.jpeg",
            "https://images.pexels.com/photos/1585325/pexels-photo-1585325.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1433052/pexels-photo-1433052.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/1020016/pexels-photo-1020016.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/users/avatars/215243/dominika-roseclay-113.jpeg",
            "https://images.pexels.com/photos/60597/dahlia-red-blossom-bloom-60597.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/21492/pexels-photo.jpg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/325044/pexels-photo-325044.jpeg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/photos/33109/fall-autumn-red-season.jpg?auto=compress&cs=tinysrgb&w=1600",
            "https://images.pexels.com/users/avatars/135125/irina-iriser-366.jpeg",
            "https://images.pexels.com/users/avatars/2462/bob-clark-355.jpeg",
            "https://images.pexels.com/users/avatars/333270/oliver-sjostrom-718.jpeg",
            "https://images.pexels.com/users/avatars/372897/max-andrey-928.jpeg",
            "https://images.pexels.com/users/avatars/22704/tausif-hossain-836.jpeg",
            "https://images.pexels.com/users/avatars/1268114/roberto-nickson-477.jpeg",
            "https://images.pexels.com/users/avatars/1074/deepu-b-iyer-322.jpeg",
            "https://images.pexels.com/users/avatars/487/tetyana-kovyrina-416.jpeg",
            "https://images.pexels.com/photos/1784578/pexels-photo-1784578.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1598073/pexels-photo-1598073.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1097491/pexels-photo-1097491.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1366919/pexels-photo-1366919.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1535162/pexels-photo-1535162.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1122639/pexels-photo-1122639.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1723637/pexels-photo-1723637.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/775203/pexels-photo-775203.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/2098427/pexels-photo-2098427.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1271620/pexels-photo-1271620.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1366909/pexels-photo-1366909.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1624496/pexels-photo-1624496.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/719396/pexels-photo-719396.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/799443/pexels-photo-799443.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/937980/pexels-photo-937980.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1707215/pexels-photo-1707215.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1906658/pexels-photo-1906658.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1624438/pexels-photo-1624438.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1684151/pexels-photo-1684151.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1366913/pexels-photo-1366913.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1212487/pexels-photo-1212487.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1526713/pexels-photo-1526713.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1212600/pexels-photo-1212600.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1366630/pexels-photo-1366630.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/2486168/pexels-photo-2486168.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1367105/pexels-photo-1367105.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1420440/pexels-photo-1420440.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1699020/pexels-photo-1699020.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1334116/pexels-photo-1334116.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1381679/pexels-photo-1381679.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1192330/pexels-photo-1192330.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1906794/pexels-photo-1906794.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1257860/pexels-photo-1257860.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1253661/pexels-photo-1253661.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1105189/pexels-photo-1105189.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1156684/pexels-photo-1156684.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/40465/pexels-photo-40465.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1141792/pexels-photo-1141792.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1172849/pexels-photo-1172849.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1226302/pexels-photo-1226302.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1078983/pexels-photo-1078983.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1585325/pexels-photo-1585325.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1020016/pexels-photo-1020016.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1433052/pexels-photo-1433052.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://media.istockphoto.com/id/1153899947/photo/data-technology-abstract-futuristic-illustration-low-poly-shape-with-connecting-dots-and.jpg?b=1&s=612x612&w=0&k=20&c=50mvxAzt_hfr0opOjFL1dnlfrzn7ZUJqb1zgPoMCdG8=",
            "https://media.istockphoto.com/id/1185747322/photo/blue-mesh-gradient-blurred-motion-abstract-background.jpg?b=1&s=612x612&w=0&k=20&c=EU2Le9ohrdXYHEVfYAmiHAhYPk7eyRj5XTnJwctd7tA=",
            "https://media.istockphoto.com/id/1274394138/photo/man-using-mobile-smart-phone-with-global-network-connection-technology-innovative-and.jpg?b=1&s=612x612&w=0&k=20&c=d6O3MAj0nN24UohnvuQEZmck4cCsYy0D1I3YuMdgpu8=",
            "https://media.istockphoto.com/id/1130523814/photo/close-up-businessman-holding-smartphone-for-checking-work-or-make-appointment-and-using.jpg?b=1&s=612x612&w=0&k=20&c=vxgwuQFlDpar-5RskWCigc4Ajc_rRXm3RjyzpyddVYE=",
            "https://images.pexels.com/photos/60597/dahlia-red-blossom-bloom-60597.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/users/avatars/230606/philippe-donn-150.jpeg",
            "https://images.pexels.com/photos/325044/pexels-photo-325044.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/33109/fall-autumn-red-season.jpg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/21492/pexels-photo.jpg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/users/avatars/121938/eberhard-grossgasteiger-522.jpeg",
            "https://images.pexels.com/users/avatars/249695/arun-babu-thomas-800.jpg",
            "https://images.pexels.com/users/avatars/340699/rahul-pandit-728.jpeg}",
        )
        return imageUrls

    }
    suspend fun getSingleWallpaper(wllId:Int): WallpaperT? {
var wallpaperT: WallpaperT?=null
        for(w in getWallpapers()){
            Log.d("wall_loop","${w.id.toString()}| $wllId")
         if(w.id==wllId){
             wallpaperT=w;
         }
        }
      return wallpaperT;
    }
}