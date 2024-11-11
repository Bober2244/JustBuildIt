package dev.bober.presentation.ui.core

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun BottomBarWrapper(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            var selectedIndex by rememberSaveable { mutableIntStateOf(0) }
            val items = listOf("Home", "Search", "Places")
            val icons = listOf(
                Icons.Default.Home,
                Icons.Default.Search,
                Icons.Default.LocationOn
            )
            NavigationBar (
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = icons[index],
                                contentDescription = items[index],
                            )
                        },
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        label = {
                            Text(text = item)
                        },
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