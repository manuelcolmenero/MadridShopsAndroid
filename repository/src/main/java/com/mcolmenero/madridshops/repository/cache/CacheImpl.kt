package com.mcolmenero.madridshops.repository.cache

import android.content.Context
import com.mcolmenero.madridshops.repository.db.DBHelper
import com.mcolmenero.madridshops.repository.db.build
import com.mcolmenero.madridshops.repository.db.dao.ShopDAO
import com.mcolmenero.madridshops.repository.thread.DispatchOnMainThread
import java.lang.ref.WeakReference

internal class CacheImpl(context: Context) : Cache {
    val context = WeakReference<Context>(context)

    override fun deleteAllShops(success: () -> Unit, error: (errorMessage: String) -> Unit) {
        // Se crea un hilo de segundo plano
        Thread(Runnable {
            val successDeleting = ShopDAO(cacheDBHelper()).deleteAll()
            DispatchOnMainThread(Runnable {
                if (successDeleting) {
                    success()
                } else {
                    error("Error deleting")
                }
            })
        }).run()
    }

    private fun cacheDBHelper(): DBHelper {
        return build(
                context.get()!!,
                "MadridShops.sqlite",
                1
        )
    }
}