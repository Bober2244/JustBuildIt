package dev.bober.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import dev.bober.presentation.entity.Building
import dev.bober.presentation.entity.Order
import dev.bober.presentation.navigation.navtypes.CustomNavType
import dev.bober.presentation.ui.customer.CustomerScreen
import dev.bober.presentation.ui.home.HomeScreen
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf

@Serializable
object HomeGraph

@Serializable
object HomeRoute

@Serializable
data class CustomerScreenRoute(
    val order: Order
)

fun NavGraphBuilder.homeGraph(navController: NavController) {
    navigation<HomeGraph>(startDestination = HomeRoute) {
        composable<HomeRoute> {
            HomeScreen(
                data = data,
                onItemClick = { order ->
                    navController.navigate(
                        route = CustomerScreenRoute(
                            order = order
                        )
                    )
                }
            )
        }

        composable<CustomerScreenRoute>(
            typeMap = mapOf(
                typeOf<Order>() to CustomNavType.OrderType
            )
        ) {
            val customerScreenRoute = it.toRoute<CustomerScreenRoute>()
            CustomerScreen(
                order = customerScreenRoute.order
            )
        }
    }
}

private val data = mutableListOf(
    Order(
        customer = "Арутюнян С. В.",
        email = "sartwe204@gmail.com",
        birthday = "31.08.2004",
        phone = "",
        buildings = listOf(
            Building(
                bidDate = "19.10.2022",
                constructionPeriod = "180",
                startDate = "25.10.2022",
                endDate = "15.04.2023"
            ),
            Building(
                bidDate = "19.10.2023",
                constructionPeriod = "365",
                startDate = "25.10.2022",
                endDate = "19.9.2024"
            ),
        ),
    ),
    Order(
        customer = "Молонов Г. В.",
        email = "molokov@gmail.com",
        birthday = "20.05.2004",
        phone = "",
        buildings = listOf(),
    ),
    Order(
        customer = "Рамазанов М. А.",
        email = "ramazan@gmail.com",
        birthday = "13.11.2005",
        phone = "",
        buildings = listOf(),
    ),
    Order(
        customer = "Муталибов Ш. М.",
        email = "mutalib@gmail.com",
        birthday = "10.02.2004",
        phone = "",
        buildings = listOf(),
    ),
    Order(
        customer = "Иванов Н. С.",
        email = "ivanov@gmail.com",
        birthday = "14.07.2004",
        phone = "",
        buildings = listOf(),
    ),
    Order(
        customer = "Иванов Н. С.",
        email = "ivanov@gmail.com",
        birthday = "14.07.2004",
        phone = "",
        buildings = listOf(),
    ),
    Order(
        customer = "Иванов Н. С.",
        email = "ivanov@gmail.com",
        birthday = "14.07.2004",
        phone = "",
        buildings = listOf(),
    ),
    Order(
        customer = "Иванов Н. С.",
        email = "ivanov@gmail.com",
        birthday = "14.07.2004",
        phone = "",
        buildings = listOf(),
    ),
    Order(
        customer = "Иванов Н. С.",
        email = "ivanov@gmail.com",
        birthday = "14.07.2004",
        phone = "",
        buildings = listOf(),
    ),
    Order(
        customer = "Иванов Н. С.",
        email = "ivanov@gmail.com",
        birthday = "14.07.2004",
        phone = "",
        buildings = listOf(),
    ),
    Order(
        customer = "Галонов М. С.",
        email = "galonov@gmail.com",
        birthday = "28.12.2004",
        phone = "",
        buildings = listOf(),
    ),
)