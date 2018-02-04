package com.mcolmenero.madridshops.domain.interactor.getallshops

import android.content.Context
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
            val shop = Shop(it.id.toInt(), it.name, it.address)

            tempList.add(shop)
        }

        val shops = Shops(tempList)
        return shops
    }
}