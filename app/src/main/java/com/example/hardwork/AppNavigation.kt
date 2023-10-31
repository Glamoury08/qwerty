package com.example.hardwork

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hardwork.ui.theme.AddPage

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController  = navController, startDestination = "home") {
        composable("home") {
            HomePage(navController)
        }
        composable("add") {
            AddPage(navController)
        }
    }
}