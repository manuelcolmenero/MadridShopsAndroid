package madridshops.mcolmenero.com.repository

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import madridshops.mcolmenero.com.repository.db.build
import madridshops.mcolmenero.com.repository.db.dao.ShopDAO
import madridshops.mcolmenero.com.repository.model.ShopEntity
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

        val shop = ShopEntity(
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

        val id = shopEntityDao.insert(shop)

        assertTrue(id > 0)
    }
}
