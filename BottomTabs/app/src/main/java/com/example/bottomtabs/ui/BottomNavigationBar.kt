package com.example.bottomtabs.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        Triple("Home", "home", Icons.Default.Home),
        Triple("Settings", "settings", Icons.Default.Settings),
        Triple("Profile", "profile", Icons.Default.AccountBox)
    )
    NavigationBar {
        items.forEach { (label, route, icon) ->
            NavigationBarItem(
                icon = { Icon(icon, contentDescription = label) },
                label = { Text(text = label) },
                selected = navController.currentDestination?.route == route,
                onClick = { navController.navigate(route) }
            )
        }
    }
}