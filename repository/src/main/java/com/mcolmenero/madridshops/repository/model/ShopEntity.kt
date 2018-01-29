package com.mcolmenero.madridshops.repository.model

data class ShopEntity (
        val databaseId: Long,
        val id: Long,
        val name: String,
        val description: String,
        val latitude: Float,
        val longitude: Float,
        val image: String,
        val logo: String,
        val openingHours: String,
        val address: String

)