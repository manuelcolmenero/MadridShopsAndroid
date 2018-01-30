package com.mcolmenero.madridshops.repository

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.mcolmenero.madridshops.repository.network.GetJsonManager
import com.mcolmenero.madridshops.repository.network.GetJsonManagerVolleyImpl
import junit.framework.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class VolleyTests {
    // Context of the app under test.
    val appContext = InstrumentationRegistry.getTargetContext()


    @Test
    @Throws(Exception::class)
    fun given_valid_url_we_get_not_null_json_as_string() {

        val url = "http://madrid-shops.com/json_new/getShops.php"

        val jsonManager: GetJsonManager = GetJsonManagerVolleyImpl(appContext)

        jsonManager.execute(url, success = object: SuccessCompletion<String> {
            override fun successCompletion(element: String) {
                assert(element.isNotEmpty())
            }

        }, error = object: ErrorCompletion {
            override fun errorCompletion(errorMessage: String) {
                assertTrue(false)
            }

        })

    }
}
