package dev.bober.presentation.navigation.navtypes

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import dev.bober.presentation.entity.Order
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object CustomNavType {
    val OrderType = object : NavType<Order>(
        isNullableAllowed = false
    ) {
        override fun get(bundle: Bundle, key: String): Order? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): Order {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun put(bundle: Bundle, key: String, value: Order) {
            bundle.putString(key, Json.encodeToString(value))
        }

        override fun serializeAsValue(value: Order): String {
            return Uri.encode(Json.encodeToString(value))
        }
    }
}