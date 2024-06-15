package org.d3if0108.assessment3mobpro1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.d3if0108.assessment3mobpro1.ui.screen.MainScreen
import org.d3if0108.assessment3mobpro1.ui.screen.InfoObatScreen
import org.d3if0108.assessment3mobpro1.ui.screen.AboutScreen

@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            MainScreen(navController)
        }
        composable(route = Screen.InfoObat.route) {
            InfoObatScreen(navController)
        }
        composable(route = Screen.About.route) {
            AboutScreen(navController)
        }
    }
}
