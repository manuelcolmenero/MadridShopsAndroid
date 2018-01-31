package com.mcolmenero.madridshops.repository

interface Repository {
    fun deleteAllShops (success: () -> Unit, error: (errorMessage: String) -> Unit)

}