package com.mcolmenero.madridshops.repository.cache

import android.content.Context
import com.mcolmenero.madridshops.repository.db.DBHelper
import com.mcolmenero.madridshops.repository.db.build
import com.mcolmenero.madridshops.repository.db.dao.ShopDAO
import com.mcolmenero.madridshops.repository.model.ShopEntity
import com.mcolmenero.madridshops.repository.thread.DispatchOnMainThread
import java.lang.ref.WeakReference

internal class CacheImpl(context: Context) : Cache {

    val context = WeakReference<Context>(context)

    override fun getAllShops(success: (shops: List<ShopEntity>) -> Unit, error: (errorMessage: String) -> Unit) {
        // Se crea un hilo de segundo plano
        Thread(Runnable {
            val shops = ShopDAO(cacheDBHelper()).query()
            DispatchOnMainThread(Runnable {
                if (shops.count() > 0) {
                    success(shops)
                } else {
                    error("No shops")
                }
            })
        }).run()
    }

    override fun saveAllShops(shops: List<ShopEntity>, success: () -> Unit, error: (errorMessage: String) -> Unit) {
        // Se crea un hilo de segundo plano
        Thread(Runnable {
            try {
                shops.forEach {
                    ShopDAO(cacheDBHelper()).insert(it)
                }

                DispatchOnMainThread(Runnable { success() })
            } catch (e: Exception) {
                DispatchOnMainThread(Runnable {
                    error("Error inserting shops")
                })
            }
        }).run()

    }

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