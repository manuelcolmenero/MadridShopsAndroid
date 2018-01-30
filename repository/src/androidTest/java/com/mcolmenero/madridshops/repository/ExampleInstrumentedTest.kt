package com.mcolmenero.madridshops.repository

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
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

        val shopEntityDao = ShopDAO(dbHelper)

        val deleteAll = shopEntityDao.deleteAll()


        val id = shopEntityDao.insert(shop1)

        assertTrue(id > 0)

    }
}
