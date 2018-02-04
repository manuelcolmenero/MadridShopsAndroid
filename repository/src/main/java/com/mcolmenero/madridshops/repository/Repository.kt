package com.mcolmenero.madridshops.repository

import com.mcolmenero.madridshops.repository.model.ShopEntity

interface Repository {
    fun deleteAllShops (success: () -> Unit, error: (errorMessage: String) -> Unit)
    fun getAllShops (success: (shops: List<ShopEntity>) -> Unit, error: (errorMessage: String) -> Unit)
}