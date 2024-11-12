package dev.bober.presentation.entity

import kotlinx.serialization.Serializable

@Serializable
data class Building(
    val bidDate: String,
    val constructionPeriod: String,
    val startDate: String,
    val endDate: String,
)
