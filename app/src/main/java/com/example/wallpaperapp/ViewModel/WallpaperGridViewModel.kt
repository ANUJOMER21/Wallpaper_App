package com.example.wallpaperapp.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.wallpaperapp.Repository.Model.WallpaperT
import com.example.wallpaperapp.Repository.WallpaperRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WallpaperGridViewModel(app: Application) : AndroidViewModel(app) {
    private val repository = WallpaperRepository()

    // State management with StateFlow for better Compose integration
    private val _wallpapers = MutableStateFlow<List<WallpaperT>>(emptyList())
    val wallpapers: StateFlow<List<WallpaperT>> = _wallpapers.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    // Keep LiveData for click events if needed for navigation
    private val _clickEvent = MutableLiveData<Int>()
    val clickEventLiveData: LiveData<Int> = _clickEvent

    // Alternative StateFlow approach for click events
    private val _selectedWallpaperId = MutableStateFlow<Int?>(null)
    val selectedWallpaperId: StateFlow<Int?> = _selectedWallpaperId.asStateFlow()

    /**
     * Fetches main wallpapers from repository
     */
    fun fetchWallpapers() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                val result = repository.getWallpapers()
                _wallpapers.value = result ?: emptyList()

                if (result.isNullOrEmpty()) {
                    _errorMessage.value = "No wallpapers found"
                }
            } catch (e: Exception) {
                Log.e("WallpaperGridViewModel", "Error fetching wallpapers", e)
                _errorMessage.value = when (e) {
                    is java.net.UnknownHostException -> "No internet connection"
                    is java.net.SocketTimeoutException -> "Connection timeout"
                    else -> "Failed to load wallpapers: ${e.localizedMessage}"
                }
                _wallpapers.value = emptyList()
            } finally {
                _isLoading.value = false
            }
        }
    }

    /**
     * Fetches wallpapers for a specific category
     */
    fun fetchCategoryWallpapers(catId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                val result = repository.getCategoryWallpapers(catId)
                _wallpapers.value = result ?: emptyList()

                if (result.isNullOrEmpty()) {
                    _errorMessage.value = "No wallpapers found in this category"
                }
            } catch (e: Exception) {
                Log.e("WallpaperGridViewModel", "Error fetching category wallpapers", e)
                _errorMessage.value = when (e) {
                    is java.net.UnknownHostException -> "No internet connection"
                    is java.net.SocketTimeoutException -> "Connection timeout"
                    else -> "Failed to load category wallpapers: ${e.localizedMessage}"
                }
                _wallpapers.value = emptyList()
            } finally {
                _isLoading.value = false
            }
        }
    }

    /**
     * Handles wallpaper click events
     */
    fun clicked(id: Int) {
        _clickEvent.value = id
        _selectedWallpaperId.value = id
    }

    /**
     * Clears error message
     */
    fun clearError() {
        _errorMessage.value = null
    }

    /**
     * Refreshes current data
     */
    fun refresh() {
        // You might want to keep track of current mode (main vs category)
        // For now, this would need to be called from the UI with appropriate parameters
        clearError()
    }

    /**
     * Clears selected wallpaper
     */
    fun clearSelection() {
        _selectedWallpaperId.value = null
    }
}