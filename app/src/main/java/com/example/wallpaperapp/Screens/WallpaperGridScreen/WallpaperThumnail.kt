import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.icons.filled.Clear



import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import com.example.wallpaperapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WallpaperThumbnail(
    painter: Painter,
    contentDescription: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    aspectRatio: Float = 0.7f, // Default portrait aspect ratio
    cornerRadius: Int = 12
) {
    var isPressed by remember { mutableStateOf(false) }

    // Animate scale when pressed
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1f,
        animationSpec = tween(durationMillis = 150),
        label = "thumbnail_scale"
    )

    Card(
        onClick = onClick,
        modifier = modifier
            .aspectRatio(aspectRatio)
            .scale(scale)
            .semantics {
                this.contentDescription = "Wallpaper thumbnail. $contentDescription"
            },
        shape = RoundedCornerShape(cornerRadius.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
            pressedElevation = 8.dp,
            hoveredElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        interactionSource = remember { MutableInteractionSource() }.also { interactionSource ->
            LaunchedEffect(interactionSource) {
                interactionSource.interactions.collect { interaction ->
                    when (interaction) {
                        is androidx.compose.foundation.interaction.PressInteraction.Press -> {
                            isPressed = true
                        }
                        is androidx.compose.foundation.interaction.PressInteraction.Release,
                        is androidx.compose.foundation.interaction.PressInteraction.Cancel -> {
                            isPressed = false
                        }
                    }
                }
            }
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Main image
            Image(
                painter = painter,
                contentDescription = null, // Handled by card semantics
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(cornerRadius.dp)),
                contentScale = ContentScale.Crop
            )

            // Loading/Error overlay based on painter state
            when (painter) {
                is AsyncImagePainter -> {
                    when (painter.state) {
                        is AsyncImagePainter.State.Loading -> {
                            LoadingOverlay()
                        }
                        is AsyncImagePainter.State.Error -> {
                            ErrorOverlay()
                        }
                        else -> { /* Image loaded successfully */ }
                    }
                }
            }

            // Subtle gradient overlay for visual depth
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.05f)
                            ),
                            startY = 0f,
                            endY = with(LocalDensity.current) { 100.dp.toPx() }
                        ),
                        shape = RoundedCornerShape(cornerRadius.dp)
                    )
            )
        }
    }
}

@Composable
private fun LoadingOverlay() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.surface.copy(alpha = 0.8f),
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(24.dp),
            strokeWidth = 2.dp,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
private fun ErrorOverlay() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.8f),
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Clear,
            contentDescription = "Failed to load image",
            modifier = Modifier.size(32.dp),
            tint = MaterialTheme.colorScheme.onErrorContainer
        )
    }
}