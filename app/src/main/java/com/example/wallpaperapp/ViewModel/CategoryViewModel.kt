package com.example.wallpaperapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpaperapp.Repository.Model.Category
import com.example.wallpaperapp.Repository.WallpaperRepository
import kotlinx.coroutines.launch

class CategoryViewModel :ViewModel() {
    private val repository=WallpaperRepository()
    var Categories:ArrayList<Category>?=null
    private val clickEvent = MutableLiveData<Int>()
    val clickEventLiveData: LiveData<Int> = clickEvent
    fun fetchCategories(){
        viewModelScope.launch {
            try {
                Categories=repository.getCategory()
            }catch (e:Exception){

            }
        }
    }
    fun clicked(id:Int){
        clickEvent.value=id
    }
}