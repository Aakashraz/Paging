package com.example.paging.models

import kotlinx.serialization.Serializable


@Serializable
data class Dimensions(
    val depth: Double,
    val height: Double,
    val width: Double
)