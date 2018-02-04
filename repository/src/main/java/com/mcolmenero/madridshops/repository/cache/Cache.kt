package com.mcolmenero.madridshops.repository.cache

import com.mcolmenero.madridshops.repository.model.ShopEntity

internal interface Cache {
    fun deleteAllShops (success: () -> Unit, error: (errorMessage: String) -> Unit)

    fun getAllShops (success: (shops: List<ShopEntity>) -> Unit, error: (errorMessage: String) -> Unit)
    fun saveAllShops (shops: List<ShopEntity>, success: () -> Unit, error: (errorMessage: String) -> Unit)
}