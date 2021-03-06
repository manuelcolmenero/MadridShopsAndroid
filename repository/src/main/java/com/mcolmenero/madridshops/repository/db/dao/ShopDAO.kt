package com.mcolmenero.madridshops.repository.db.dao

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.mcolmenero.madridshops.repository.db.DBConstants
import com.mcolmenero.madridshops.repository.db.DBHelper
import com.mcolmenero.madridshops.repository.model.ShopEntity

/**
 * Se importa el DBHelper para poder conectar con la BD
 */
internal class ShopDAO(
        val dbHelper: DBHelper
) : DAOPersistable<ShopEntity> {
    private val dbReadOnlyConnection: SQLiteDatabase = dbHelper.readableDatabase
    private val dbReadWriteConnection: SQLiteDatabase = dbHelper.writableDatabase

    override fun query(id: Long): ShopEntity {
        val cursor = queryCursor(id)

        cursor.moveToFirst()

        return entityFromCursor(cursor)!!

    }

    override fun query(): List<ShopEntity> {
        val queryResult = ArrayList<ShopEntity>()

        val cursor = dbReadOnlyConnection.query(
                DBConstants.TABLE_SHOP,
                DBConstants.ALL_COLUMNS_SHOP,
                null,
                null,
                "",
                "",
                DBConstants.KEY_SHOP_DATABASE_ID
        )

        while (cursor.moveToNext()){
            val result = entityFromCursor(cursor)!!

            queryResult.add(result)
        }

        return queryResult
    }

    fun entityFromCursor (cursor: Cursor): ShopEntity? {

        if (cursor.isAfterLast || cursor.isBeforeFirst) {
            return  null
        }

        return ShopEntity(
                cursor.getLong(cursor.getColumnIndex(DBConstants.KEY_SHOP_ID_JSON)),
                cursor.getLong(cursor.getColumnIndex(DBConstants.KEY_SHOP_DATABASE_ID)),
                cursor.getString(cursor.getColumnIndex(DBConstants.KEY_SHOP_NAME)),
                cursor.getString(cursor.getColumnIndex(DBConstants.KEY_SHOP_DESCRIPTION_EN)),
                cursor.getString(cursor.getColumnIndex(DBConstants.KEY_SHOP_DESCRIPTION_ES)),
                cursor.getString(cursor.getColumnIndex(DBConstants.KEY_SHOP_LATITUDE)),
                cursor.getString(cursor.getColumnIndex(DBConstants.KEY_SHOP_LONGITUDE)),
                cursor.getString(cursor.getColumnIndex(DBConstants.KEY_SHOP_IMAGE_URL)),
                cursor.getString(cursor.getColumnIndex(DBConstants.KEY_SHOP_LOGO_IMAGE_URL)),
                cursor.getString(cursor.getColumnIndex(DBConstants.KEY_SHOP_OPENING_HOURS_EN)),
                cursor.getString(cursor.getColumnIndex(DBConstants.KEY_SHOP_OPENING_HOURS_ES)),
                cursor.getString(cursor.getColumnIndex(DBConstants.KEY_SHOP_ADDRESS)),
                cursor.getString(cursor.getColumnIndex(DBConstants.KEY_SHOP_TELEPHONE)),
                cursor.getString(cursor.getColumnIndex(DBConstants.KEY_SHOP_URL))
        )
    }

    override fun queryCursor(id: Long): Cursor {

        val cursor = dbReadOnlyConnection.query(
                DBConstants.TABLE_SHOP,
                DBConstants.ALL_COLUMNS_SHOP,
                DBConstants.KEY_SHOP_DATABASE_ID + " = ?",
                arrayOf(id.toString()),
                "",
                "",
                DBConstants.KEY_SHOP_DATABASE_ID
        )

        return cursor
    }

    /**
     * insert the element in DB
     */
    override fun insert(element: ShopEntity): Long {
        var id: Long = 0

        id = dbReadWriteConnection.insert(
                DBConstants.TABLE_SHOP,
                null,
                contentValues(element))


        return id
    }

     fun contentValues(shopEntity: ShopEntity): ContentValues {
         val content = ContentValues()

         // El id de la BBDD lo genera automaticamente si no se le indica
         content.put(DBConstants.KEY_SHOP_ID_JSON, shopEntity.id)
         content.put(DBConstants.KEY_SHOP_NAME, shopEntity.name)
         content.put(DBConstants.KEY_SHOP_DESCRIPTION_EN, shopEntity.description_en)
         content.put(DBConstants.KEY_SHOP_DESCRIPTION_ES, shopEntity.description_es)
         content.put(DBConstants.KEY_SHOP_LATITUDE, shopEntity.latitude)
         content.put(DBConstants.KEY_SHOP_LONGITUDE, shopEntity.longitude)
         content.put(DBConstants.KEY_SHOP_IMAGE_URL, shopEntity.img)
         content.put(DBConstants.KEY_SHOP_LOGO_IMAGE_URL, shopEntity.logo)
         content.put(DBConstants.KEY_SHOP_ADDRESS, shopEntity.address)
         content.put(DBConstants.KEY_SHOP_OPENING_HOURS_EN, shopEntity.openingHours_en)
         content.put(DBConstants.KEY_SHOP_OPENING_HOURS_ES, shopEntity.openingHours_es)
         content.put(DBConstants.KEY_SHOP_TELEPHONE, shopEntity.telephone)
         content.put(DBConstants.KEY_SHOP_URL, shopEntity.url)

        return content
    }

    override fun update(id: Long, element: ShopEntity): Long {
        val numberOfRecordsUpdate = dbReadWriteConnection.update(
                DBConstants.TABLE_SHOP,
                contentValues(element),
                DBConstants.KEY_SHOP_DATABASE_ID + " = ?",
                arrayOf(id.toString())
        )
        return numberOfRecordsUpdate.toLong()
    }

    /**
     * deletes the element passed from DB
     */
    override fun delete(element: ShopEntity): Long {
        if (element.databaseId > 1) return 0

        return delete(element.databaseId)
    }

    /**
     * deletes the element with id from DB
     */
    override fun delete(id: Long): Long {

        return dbReadWriteConnection.delete(
                DBConstants.TABLE_SHOP,
                DBConstants.KEY_SHOP_DATABASE_ID + " = ?",
                arrayOf(id.toString())
        ).toLong()

    }

    override fun deleteAll(): Boolean {
        return dbReadWriteConnection.delete(
                DBConstants.TABLE_SHOP,
                null,
                null
        ).toLong() >= 0
    }

}