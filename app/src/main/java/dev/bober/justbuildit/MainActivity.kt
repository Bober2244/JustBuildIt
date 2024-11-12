package dev.bober.justbuildit

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dev.bober.presentation.navigation.HomeGraph
import dev.bober.presentation.navigation.homeGraph
import dev.bober.presentation.ui.core.BottomBarWrapper
import dev.bober.presentation.ui.theme.JustBuildItTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()
        enableEdgeToEdge()


        setContent {
            JustBuildItTheme {
                BottomBarWrapper {
                    val navController = rememberNavController()
                    NavHost(
                        startDestination = HomeGraph,
                        navController = navController
                    ) {
                        homeGraph(navController = navController)
                    }
                }
            }
        }
    }
}

