package dev.bober.justbuildit

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dev.bober.presentation.entity.Order
import dev.bober.presentation.ui.core.BottomBarWrapper
import dev.bober.presentation.ui.home.HomeScreen
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
                    HomeScreen(
                        data = data
                    )
                }
            }
        }
    }
}

private val data = mutableListOf(
    Order(
        customer = "Арутюнян С. В.",
        email = "sartwe204@amil.com",
        birthday = "31.08.2004",
        phone = "",
        startDate = "",
        endDate = "",
    ),
    Order(
        customer = "Молонов Г. В.",
        email = "molokov@gmail.com",
        birthday = "20.05.2004",
        phone = "",
        startDate = "",
        endDate = "",
    ),
    Order(
        customer = "Рамазанов М. А.",
        email = "ramazan@gmail.com",
        birthday = "13.11.2005",
        phone = "",
        startDate = "",
        endDate = "",
    ),
    Order(
        customer = "Муталибов Ш. М.",
        email = "mutalib@gmail.com",
        birthday = "10.02.2004",
        phone = "",
        startDate = "",
        endDate = "",
    ),
    Order(
        customer = "Иванов Н. С.",
        email = "ivanov@gmail.com",
        birthday = "14.07.2004",
        phone = "",
        startDate = "",
        endDate = "",
    ),
    Order(
        customer = "Иванов Н. С.",
        email = "ivanov@gmail.com",
        birthday = "14.07.2004",
        phone = "",
        startDate = "",
        endDate = "",
    ),
    Order(
        customer = "Иванов Н. С.",
        email = "ivanov@gmail.com",
        birthday = "14.07.2004",
        phone = "",
        startDate = "",
        endDate = "",
    ),
    Order(
        customer = "Иванов Н. С.",
        email = "ivanov@gmail.com",
        birthday = "14.07.2004",
        phone = "",
        startDate = "",
        endDate = "",
    ),
    Order(
        customer = "Иванов Н. С.",
        email = "ivanov@gmail.com",
        birthday = "14.07.2004",
        phone = "",
        startDate = "",
        endDate = "",
    ),
    Order(
        customer = "Иванов Н. С.",
        email = "ivanov@gmail.com",
        birthday = "14.07.2004",
        phone = "",
        startDate = "",
        endDate = "",
    ),
    Order(
        customer = "Галонов М. С.",
        email = "galonov@gmail.com",
        birthday = "28.12.2004",
        phone = "",
        startDate = "",
        endDate = "",
    ),
)