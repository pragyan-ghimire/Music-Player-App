package com.example.jetmusicplayer.navigations

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetmusicplayer.screens.HomeScreen
import com.example.jetmusicplayer.screens.PlayScreen

@Composable
fun MusicNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationScreens.HomeScreen.name
    ) {
        composable(route = NavigationScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        composable(
            route = NavigationScreens.PlayScreen.name + "/{song}",
            arguments = listOf(navArgument(name = "song") { type = NavType.StringType })
        ) { backStackEntry ->
            PlayScreen(
                navController = navController,
                modifier=Modifier,
                backStackEntry.arguments?.getString("song")
            )
        }
    }
}