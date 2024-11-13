package dev.bober.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.bober.presentation.ui.login.LoginScreen
import dev.bober.presentation.ui.users.SelectUserType
import kotlinx.serialization.Serializable

@Serializable
object LoginGraph

@Serializable
object LoginRoute

@Serializable
object SelectUserTypeRoute

fun NavGraphBuilder.loginGraph(navController: NavController) {
    navigation<LoginGraph>(startDestination = SelectUserTypeRoute) {
        composable<SelectUserTypeRoute> {
            SelectUserType(
                onUserTypeClick = {
                    navController.navigate(LoginRoute)
                }
            )
        }

        composable<LoginRoute> {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(HomeGraph)
                }
            )
        }
    }
}