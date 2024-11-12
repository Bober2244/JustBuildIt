package dev.bober.presentation.entity

import kotlinx.serialization.Serializable

@Serializable
data class Order(
    val customer: String,
    val email: String,
    val birthday: String,
    val phone: String,
    val buildings: List<Building>,
    //TODO("дописать")
)
