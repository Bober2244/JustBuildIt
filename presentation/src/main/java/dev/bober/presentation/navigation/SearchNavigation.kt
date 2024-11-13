package dev.bober.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.bober.presentation.ui.search.SearchScreen
import kotlinx.serialization.Serializable

@Serializable
object SearchGraph

@Serializable
object SearchScreenRoute

fun NavGraphBuilder.searchGraph(navController: NavController) {
    navigation<SearchGraph>(startDestination = SearchScreenRoute) {
        composable<SearchScreenRoute> {
            SearchScreen(
                searchQuery = "",
                onBackClick = {
                    navController.navigateUp()
                },
                onSearchQueryChanged = {
                    /*TODO("")*/
                },
                onSearchTriggered = {
                    /*TODO("вставить строку из предыдущих запросов в поисковую")*/
                }
            )
        }
    }
}