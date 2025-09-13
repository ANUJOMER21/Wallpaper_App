package com.example.wallpaperapp.Screens.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import coil.ImageLoader


import com.example.wallpaperapp.Screens.Activity.ui.theme.WallpaperAppTheme
import com.example.wallpaperapp.Screens.WallpaperGridScreen.WallpaperGrid
import com.example.wallpaperapp.ViewModel.WallpaperGridViewModel

@OptIn(ExperimentalMaterial3Api::class)
class CategoryWallpaperScreen : ComponentActivity() {
    private val viewModel: WallpaperGridViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get category ID from intent with proper error handling
        val categoryId = intent.getIntExtra("catid", -1)
        val categoryName = intent.getStringExtra("category_name") ?: "Category"

        if (categoryId == -1) {
            // Invalid category ID, finish activity
            finish()
            return
        }

        setContent {
            WallpaperAppTheme {
                CategoryWallpaperContent(
                    viewModel = viewModel,
                    categoryId = categoryId,
                    categoryName = categoryName,
                    onBackPressed = { finish() },
                    onWallpaperSelected = { wallpaperId ->
                        navigateToWallpaperScreen(wallpaperId)
                    }
                )
            }
        }

        // Observe click events for navigation
        observeWallpaperClicks()
    }

    private fun observeWallpaperClicks() {
        viewModel.clickEventLiveData.observe(this) { wallpaperId ->
            navigateToWallpaperScreen(wallpaperId)
        }
    }

    private fun navigateToWallpaperScreen(wallpaperId: Int) {
        val intent = Intent(this, WallpaperScreen::class.java).apply {
            putExtra("wallid", wallpaperId)
            // Pass category info for context
            putExtra("catid", intent.getIntExtra("catid", -1))
            putExtra("category_name", intent.getStringExtra("category_name"))
        }
        startActivity(intent)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CategoryWallpaperContent(
    viewModel: WallpaperGridViewModel,
    categoryId: Int,
    categoryName: String,
    onBackPressed: () -> Unit,
    onWallpaperSelected: (Int) -> Unit
) {
    val context = LocalContext.current

    // Create optimized ImageLoader
    val imageLoader = remember {
        ImageLoader.Builder(context)

            .crossfade(true)
           // Remove in production
            .build()
    }

    // Collect state from ViewModel using collectAsState
    val wallpapers by viewModel.wallpapers.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    Scaffold(
        topBar = {
            CategoryTopBar(
                categoryName = categoryName,
                onBackPressed = onBackPressed,
                wallpaperCount = wallpapers.size,
                isLoading = isLoading
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.background,
                            MaterialTheme.colorScheme.surface.copy(alpha = 0.8f)
                        )
                    )
                )
        ) {
            WallpaperGrid(
                viewModel = viewModel,
                imageLoader = imageLoader,
                type = 2, // Category type
                catid = categoryId,
                modifier = Modifier.fillMaxSize()
            )

            // Pull-to-refresh indicator
            if (isLoading && wallpapers.isNotEmpty()) {
                Card(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.9f)
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(16.dp),
                            strokeWidth = 2.dp,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "Refreshing...",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }

    // Handle click events within Compose
    LaunchedEffect(viewModel) {
        viewModel.selectedWallpaperId.collect { wallpaperId ->
            wallpaperId?.let {
                onWallpaperSelected(it)
                viewModel.clearSelection() // Clear selection after handling
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CategoryTopBar(
    categoryName: String,
    onBackPressed: () -> Unit,
    wallpaperCount: Int,
    isLoading: Boolean
) {
    TopAppBar(
        title = {
            Column {
                Text(
                    text = categoryName,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                if (!isLoading && wallpaperCount > 0) {
                    Text(
                        text = "$wallpaperCount wallpapers",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        },
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.95f),
            titleContentColor = MaterialTheme.colorScheme.onSurface,
            navigationIconContentColor = MaterialTheme.colorScheme.onSurface
        )
    )
}