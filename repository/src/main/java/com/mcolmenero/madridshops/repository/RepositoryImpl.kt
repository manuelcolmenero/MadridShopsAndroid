package com.mcolmenero.madridshops.repository

import android.content.Context
import com.mcolmenero.madridshops.repository.cache.Cache
import com.mcolmenero.madridshops.repository.cache.CacheImpl
import java.lang.ref.WeakReference


class RepositoryImpl(context: Context): Repository{
    val context = WeakReference<Context>(context)

    override fun deleteAllShops(success: () -> Unit, error: (errorMessage: String) -> Unit) {
        val cache: Cache = CacheImpl(context.get()!!)

        cache.deleteAllShops(success, error)
    }
}