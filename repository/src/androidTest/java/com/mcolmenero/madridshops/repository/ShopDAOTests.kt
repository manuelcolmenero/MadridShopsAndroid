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
class ShopDAOTests {
    // Context of the app under test.
    private val appContext = InstrumentationRegistry.getTargetContext()

    // Connection to DB
    private val dbHelper = build(appContext, "mydb.sqlite", 1)

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

        // val deleteAll = shopEntityDao.deleteAll()


        val id = shopEntityDao.insert(shop1)

        assertTrue(id > 0)

    }


    // TODO: Convert into a valid test
    private fun test() {

        val shopEntityDao = ShopDAO(dbHelper)


        // val deletedAll = shopEntityDao.deleteAll()

        val shop = ShopEntity(1,1,"My shop 1", "desc 1"
                , 1.0f, 2.0f,"","", "", "")


        val shop2 = ShopEntity(2,1,"My shop 2", "desc 2"
                , 1.0f, 2.0f,"","", "", "")


        val id = shopEntityDao.insert(shop)
        val id2 = shopEntityDao.insert(shop2)

        shopEntityDao.query().forEach {
            Log.d("Shop", it.name + " - " + it.description)

        }
    }
}
