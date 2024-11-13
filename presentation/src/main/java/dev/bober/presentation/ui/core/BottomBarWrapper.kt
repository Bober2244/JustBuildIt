package dev.bober.presentation.ui.core

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import dev.bober.presentation.navigation.HomeGraph
import dev.bober.presentation.navigation.SearchGraph

@Composable
fun BottomBarWrapper(
    navController: NavController,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val bottomDestinations = listOf(HomeGraph, SearchGraph)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            val items = listOf("Главная", "Поиск", "Адреса")
            val icons = listOf(
                Icons.Default.Home,
                Icons.Default.Search,
                Icons.Default.LocationOn
            )
            NavigationBar (
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            ) {
                val entry by navController.currentBackStackEntryAsState()
                val currentDestination = entry?.destination

                bottomDestinations.forEachIndexed { index, destination ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = icons[index],
                                contentDescription = items[index],
                            )
                        },
                        selected = currentDestination?.hierarchy?.any {
                            it.hasRoute(destination::class)
                        } == true,
                        onClick = {
                            navController.navigate(destination)
                        },
                        label = {
                            Text(text = items[index])
                        },
                        colors = NavigationBarItemColors(
                            selectedTextColor = MaterialTheme.colorScheme.background,
                            selectedIconColor = MaterialTheme.colorScheme.primaryContainer,
                            selectedIndicatorColor = MaterialTheme.colorScheme.surface,
                            unselectedTextColor = MaterialTheme.colorScheme.onBackground,
                            unselectedIconColor = MaterialTheme.colorScheme.onBackground,
                            disabledIconColor = MaterialTheme.colorScheme.onBackground,
                            disabledTextColor = MaterialTheme.colorScheme.onBackground,
                        )
                    )
                }
            }
        },
    ) { innerPadding ->
        Surface(
            modifier = modifier.padding(innerPadding)
        ) {
            content()
        }

    }
}