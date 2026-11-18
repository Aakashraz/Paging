package com.example.paging.models

import kotlinx.serialization.Serializable


@Serializable
data class ProductResponse(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)