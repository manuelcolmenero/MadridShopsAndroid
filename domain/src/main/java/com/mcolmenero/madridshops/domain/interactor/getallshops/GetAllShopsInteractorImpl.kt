package com.mcolmenero.madridshops.domain.interactor.getallshops

import android.content.Context
import android.util.Log
import com.mcolmenero.madridshops.domain.interactor.ErrorCompletion
import com.mcolmenero.madridshops.domain.interactor.SuccessCompletion
import com.mcolmenero.madridshops.domain.model.Shop
import com.mcolmenero.madridshops.domain.model.Shops
import com.mcolmenero.madridshops.repository.Repository
import com.mcolmenero.madridshops.repository.RepositoryImpl
import com.mcolmenero.madridshops.repository.model.ShopEntity
import java.lang.ref.WeakReference

class GetAllShopsInteractorImpl(context: Context) : GetAllShopsInteractor {

    private val weakContext = WeakReference<Context>(context)
    private val repository: Repository = RepositoryImpl(weakContext.get()!!)

    override fun execute(success: SuccessCompletion<Shops>, error: ErrorCompletion) {
        repository.getAllShops(success = {
            val shops : Shops = entityMapper(it)

            success.successCompletion(shops)

        }, error = {
            error(it)
        })
    }

    private fun entityMapper(list: List<ShopEntity>): Shops {
        val tempList = ArrayList<Shop>()

        list.forEach {
            val shop = Shop(
                    it.id,
                    it.name,
                    it.description_en,
                    it.description_es,
                    parseStringToDouble(it.latitude),
                    parseStringToDouble(it.longitude),
                    it.img,
                    it.logo,
                    it.openingHours_en,
                    it.openingHours_es,
                    it.address,
                    it.telephone,
                    it.url)

            tempList.add(shop)
        }

        return Shops(tempList)
    }

    private fun parseStringToDouble(value: String): Double? {
        var coordinate: Double? = null

        val parsedString: String = value.replace(",", "").replace(" ", "")

        try {
            coordinate = parsedString.toDouble()
        } catch (e: Exception) {
            Log.d("PARSE ERROR", "💩 Error parsing to float: " + value)
        }

        return coordinate
    }
}