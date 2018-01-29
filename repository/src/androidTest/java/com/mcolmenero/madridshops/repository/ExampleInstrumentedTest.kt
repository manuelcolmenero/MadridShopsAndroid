package com.mcolmenero.madridshops.repository

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.util.Log
import com.mcolmenero.madridshops.repository.db.build
import com.mcolmenero.madridshops.repository.db.dao.ShopDAO
import com.mcolmenero.madridshops.repository.model.ShopEntity
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    // Context of the app under test.
    val appContext = InstrumentationRegistry.getTargetContext()

    // Connection to DB
    val dbHelper = build(appContext, "mydb.sqlite", 1)

    @Test
    @Throws(Exception::class)
    fun given_valid_shop_it_gets_inserted_correctly() {


        val shop1 = ShopEntity(
                1,
                1,
                "My shop",
                "",
                1.0f,
                2.0f,
                "",
                "",
                "",
                ""
        )

        val shop2 = ShopEntity(
                2,
                2,
                "My shop 2",
                "",
                1.0f,
                2.0f,
                "",
                "",
                "",
                ""
        )


        val shopEntityDao = ShopDAO(dbHelper)

        Log.d("MANU", "Conexión")

        val deleteAll = shopEntityDao.deleteAll()
        Log.d("MANU", "Borrado de todo")


        val id1 = shopEntityDao.insert(shop1)
        val id2 = shopEntityDao.insert(shop2)
        Log.d("MANU", "Doble insert")


        shopEntityDao.query().forEach {
            Log.d("MANU", it.name)

        }
    }
}
