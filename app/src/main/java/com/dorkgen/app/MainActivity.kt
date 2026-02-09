package com.dorkgen.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dorkgen.app.ui.screens.*
import com.dorkgen.app.ui.theme.DorkGeneratorTheme
import com.dorkgen.app.viewmodel.DorkViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: DorkViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DorkGeneratorTheme {
                DorkGeneratorApp(viewModel)
            }
        }
    }
}

sealed class Screen(val route: String, val title: String, val icon: androidx.compose.ui.graphics.vector.ImageVector) {
    object Home : Screen("home", "Accueil", Icons.Default.Home)
    object History : Screen("history", "Historique", Icons.Default.History)
    object Favorites : Screen("favorites", "Favoris", Icons.Default.Favorite)
    object Settings : Screen("settings", "Paramètres", Icons.Default.Settings)
    object Generator : Screen("generator/{categoryId}", "Générateur", Icons.Default.Add) {
        fun createRoute(categoryId: String?) = if (categoryId != null) "generator/$categoryId" else "generator/null"
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DorkGeneratorApp(viewModel: DorkViewModel) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    
    val bottomNavItems = listOf(
        Screen.Home,
        Screen.History,
        Screen.Favorites,
        Screen.Settings
    )
    
    val showBottomBar = currentDestination?.route in bottomNavItems.map { it.route }
    
    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar {
                    bottomNavItems.forEach { screen ->
                        NavigationBarItem(
                            icon = { Icon(screen.icon, contentDescription = screen.title) },
                            label = { Text(screen.title) },
                            selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    viewModel = viewModel,
                    onNavigateToGenerator = { categoryId ->
                        navController.navigate(Screen.Generator.createRoute(categoryId))
                    }
                )
            }
            
            composable(Screen.Generator.route) { backStackEntry ->
                val categoryId = backStackEntry.arguments?.getString("categoryId")
                GeneratorScreen(
                    viewModel = viewModel,
                    categoryId = if (categoryId == "null") null else categoryId,
                    onNavigateBack = { navController.popBackStack() }
                )
            }
            
            composable(Screen.History.route) {
                HistoryScreen(viewModel = viewModel)
            }
            
            composable(Screen.Favorites.route) {
                FavoritesScreen(viewModel = viewModel)
            }
            
            composable(Screen.Settings.route) {
                SettingsScreen(viewModel = viewModel)
            }
        }
    }
}
