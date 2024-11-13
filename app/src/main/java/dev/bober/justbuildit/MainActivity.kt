package dev.bober.justbuildit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dev.bober.presentation.navigation.LoginGraph
import dev.bober.presentation.navigation.homeGraph
import dev.bober.presentation.navigation.loginGraph
import dev.bober.presentation.navigation.searchGraph
import dev.bober.presentation.ui.core.BottomBarWrapper
import dev.bober.presentation.ui.theme.JustBuildItTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()
        enableEdgeToEdge()


        setContent {
            JustBuildItTheme {
                val navController = rememberNavController()
                BottomBarWrapper(
                    navController = navController
                ) {
                    NavHost(
                        startDestination = LoginGraph,
                        navController = navController
                    ) {
                        loginGraph(navController = navController)
                        homeGraph(navController = navController)
                        searchGraph(navController = navController)
                    }
                }
            }
        }
    }
}

