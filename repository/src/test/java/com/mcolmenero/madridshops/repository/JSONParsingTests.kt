package com.mcolmenero.madridshops.repository

import com.mcolmenero.madridshops.repository.model.ShopEntity
import com.mcolmenero.madridshops.repository.network.json.JsonEntitiesParser
import com.mcolmenero.madridshops.utils.ReadJsonFile
import junit.framework.Assert.*
import org.junit.Test


class JSONParsingTests {
    @Test
    @Throws(Exception::class)
    fun given_valid_string_containing_json_it_parse_correctly() {
        val shopsJson = ReadJsonFile().loadJSONFromAsset("shop.json")
        assertTrue(false == shopsJson.isEmpty())

        /**
         * Parsing
         */

        val parser = JsonEntitiesParser()
        val shop = parser.parse<ShopEntity>(shopsJson)

        assertNotNull(shop)
        assertEquals("Cortefiel -Preciados", shop.name)
    }
}