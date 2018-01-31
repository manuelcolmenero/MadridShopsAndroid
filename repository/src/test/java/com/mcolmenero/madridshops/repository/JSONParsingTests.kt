package com.mcolmenero.madridshops.repository

import com.mcolmenero.madridshops.repository.model.ShopEntity
import com.mcolmenero.madridshops.repository.model.ShopsResponseEntity
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
        assertEquals("Cortefiel - Preciados", shop.name)
        assertEquals(40.4180563f, shop.latitude, 0.1f)
    }

    @Test
    @Throws(Exception::class)
    fun given_valid_string_containing_json_shops_it_parse_correctly_all_shops() {
        val shopsJson = ReadJsonFile().loadJSONFromAsset("shops.json")
        assertTrue(false == shopsJson.isEmpty())

        /**
         * Parsing
         */

        val parser = JsonEntitiesParser()
        val responseEntity = parser.parse<ShopsResponseEntity>(shopsJson)

        assertNotNull(responseEntity)
        assertEquals(6, responseEntity.result.count())
        assertEquals("Cortefiel - Preciados", responseEntity.result[0].name)
        assertEquals(40.4180563f, responseEntity.result[0].latitude, 0.1f)
    }
}