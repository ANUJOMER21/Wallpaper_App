package com.example.wallpaperapp.Screens.BottomNavigation

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState



@SuppressLint("RestrictedApi")
@Composable
fun BottomBar(navController: NavHostController, state: MutableState<Boolean>, modifier: Modifier = Modifier){
    val screens= listOf(
        BottomNavigationScreens.wallpapers,
        BottomNavigationScreens.category,
        BottomNavigationScreens.profile
    )
    val slideInTransition = remember {
        slideInVertically(
            initialOffsetY = { it },
            animationSpec = tween(300) // Adjust the duration as needed
        )
    }

    val slideOutTransition = remember {
        slideOutVertically(
            targetOffsetY = { it },
            animationSpec = tween(300) // Adjust the duration as needed
        )
    }
    AnimatedVisibility(
        visible = state.value,
        enter = slideInTransition  ,
        exit = slideOutTransition,
    ) {
        NavigationBar(
            modifier = modifier,
            containerColor = Color.White,
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            screens.forEach { screen ->
                NavigationBarItem(
                    label = {
                        Text(text = screen.title!!)
                    },
                    icon = {
                        Icon(painterResource(id = screen.icon), contentDescription = "")
                    },
                    selected = currentRoute == screen.route,
                    onClick = {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        unselectedTextColor = Color.Black, selectedTextColor = Color.Black,
                    ),


                )
            }
        }
    }
}