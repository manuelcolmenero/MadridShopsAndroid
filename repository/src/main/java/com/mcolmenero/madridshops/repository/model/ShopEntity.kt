package com.mcolmenero.madridshops.repository.model

data class ShopEntity(
        val databaseId: Long,
        val id: Long,
        val name: String,
        val description_en: String,
        val gps_lat: Float,
        val gps_lon: Float,
        val img: String,
        val logo_img: String,
        val opening_hours_en: String = "",
        val address: String = ""
        // TODO: añadir todos los campos de shop.json
)